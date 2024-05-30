package main.java.com.bookrec;

import main.java.com.bookrec.facade.FacadeSearch;
import main.java.com.bookrec.facade.FacadePreferences;
import main.java.com.bookrec.model.Book;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FacadeSearch facadeSearch = FacadeSearch.getTheInstance();
        FacadePreferences facadePreferences = FacadePreferences.getTheInstance();

        // Load or create preferences file
        System.out.println("Do you want to load preferences from a file? (yes/no)");
        String loadPrefs = scanner.nextLine();
        if (loadPrefs.equalsIgnoreCase("yes")) {
            System.out.println("Enter the directory for preferences file:");
            String directory = scanner.nextLine();
            System.out.println("Enter the filename for preferences:");
            String filename = scanner.nextLine();
            facadePreferences.loadPreferences(directory, filename);
            facadePreferences.displayPreferences();
        }

        // Search functionality
        System.out.println("Enter search type (title/rating):");
        String searchType = scanner.nextLine();

        if (searchType.equalsIgnoreCase("rating")) {
            System.out.println("Enter minimum rating (1.0 to 5.0):");
            double minRating = scanner.nextDouble();
            scanner.nextLine(); // consume the leftover newline

            List<Book> ratedBooks = facadeSearch.searchByMinimumRating(minRating);
            System.out.println("Search Results by Minimum Rating:");
            displayBooks(ratedBooks);
        } else if (searchType.equalsIgnoreCase("title")) {
            System.out.println("Enter a title to search for:");
            String titleSearch = scanner.nextLine();
            List<Book> titleResults = facadeSearch.searchByTitle(titleSearch);
            System.out.println("Search Results by Title:");
            displayBooks(titleResults);
        } else {
            System.out.println("Invalid search type selected.");
        }

        // Rate and save a book
        System.out.println("Would you like to rate a book? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the title of the book to rate:");
            String bookTitle = scanner.nextLine();
            List<Book> books = facadeSearch.searchByTitle(bookTitle);
            if (!books.isEmpty()) {
                Book book = books.get(0);  // Assume first match for simplicity
                System.out.println("Enter your rating (1 to 5):");
                int rating = scanner.nextInt();
                scanner.nextLine(); // consume newline
                book.addRating(rating);
                System.out.println("Rating added. Book now has an average rating of " + book.getAverageRating());
            } else {
                System.out.println("Book not found.");
            }
        }

        // Optionally save updated preferences
        System.out.println("Would you like to save your preferences? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the directory to save your preferences:");
            String saveDir = scanner.nextLine();
            System.out.println("Enter the filename to save your preferences:");
            String saveFile = scanner.nextLine();
            facadePreferences.savePreferences(saveDir, saveFile);
            System.out.println("Preferences saved.");
        }
    }

    private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }
}
