package main.java.com.bookrec;

import main.java.com.bookrec.facade.FacadePreferences;
import main.java.com.bookrec.facade.FacadeSearch;
import main.java.com.bookrec.model.Book;
import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FacadePreferences facadePreferences = FacadePreferences.getTheInstance();
        FacadeSearch facadeSearch = FacadeSearch.getTheInstance();

        System.out.println("Would you like to load your preferences from a file? (yes/no)");
        String loadFromFile = scanner.nextLine();

        if (loadFromFile.equalsIgnoreCase("yes")) {
            System.out.println("Please enter the directory (e.g., input):");
            String directory = scanner.nextLine();
            System.out.println("Please enter the filename (e.g., userPreferences.txt):");
            String filename = scanner.nextLine();

            facadePreferences.loadPreferences(directory, filename);
        } else {
            System.out.println("Enter your favorite genre:");
            facadePreferences.addFavoriteGenre(scanner.nextLine());
            System.out.println("Enter your preferred author:");
            facadePreferences.addPreferredAuthor(scanner.nextLine());
            System.out.println("Enter a previously read book:");
            facadePreferences.addPreviouslyReadBook(scanner.nextLine());

            System.out.println("Please enter the directory to save your preferences (e.g., output):");
            String saveDirectory = scanner.nextLine();
            System.out.println("Please enter the filename to save your preferences (e.g., userPreferences.txt):");
            String saveFilename = scanner.nextLine();
            facadePreferences.savePreferences(saveDirectory, saveFilename);
        }

        facadePreferences.displayPreferences();

        System.out.println("Enter a title to search for:");
        String titleSearch = scanner.nextLine();
        List<Book> titleResults = facadeSearch.searchByTitle(titleSearch);
        System.out.println("Search Results by Title:");
        displayBooks(titleResults);

        System.out.println("Enter an author to search for:");
        String authorSearch = scanner.nextLine();
        List<Book> authorResults = facadeSearch.searchByAuthor(authorSearch);
        System.out.println("Search Results by Author:");
        displayBooks(authorResults);

        System.out.println("Enter a genre to search for:");
        String genreSearch = scanner.nextLine();
        List<Book> genreResults = facadeSearch.searchByGenre(genreSearch);
        System.out.println("Search Results by Genre:");
        displayBooks(genreResults);

        // Add new books to the search system
        facadeSearch.addBook(new FictionBook("New Fiction Book", "New Author", "Fiction", "Adventure"));
        facadeSearch.addBook(new NonFictionBook("New Non-Fiction Book", "New Author", "Non-Fiction", "Science"));
    }

    private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }
}
