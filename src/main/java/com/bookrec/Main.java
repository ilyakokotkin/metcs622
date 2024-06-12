package main.java.com.bookrec;

import main.java.com.bookrec.facade.FacadeSearch;
import main.java.com.bookrec.facade.FacadePreferences;
import main.java.com.bookrec.model.Book;
import main.java.com.bookrec.preferences.UserPreferences;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static FacadeSearch facadeSearch = FacadeSearch.getTheInstance();
    private static FacadePreferences facadePreferences = FacadePreferences.getTheInstance();

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        int option = 0;

        while (option != 9) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Load Preferences");
            System.out.println("2. Get Book Recommendations");
            System.out.println("3. Search Books");
            System.out.println("4. Rate a Book");
            System.out.println("5. Manage Preferences");
            System.out.println("6. Save Preferences");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    loadPreferences();
                    break;
                case 2:
                    recommendBooks();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    rateBook();
                    break;
                case 5:
                    managePreferences();
                    break;
                case 6:
                    savePreferences();
                    break;
                case 9:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void loadPreferences() {
        System.out.println("Enter the directory for preferences file:");
        String directory = scanner.nextLine();
        System.out.println("Enter the filename for preferences:");
        String filename = scanner.nextLine();
        facadePreferences.loadPreferences(directory, filename);
        facadePreferences.displayPreferences();
    }

    private static void recommendBooks() {
        UserPreferences userPreferences = facadePreferences.getUserPreferences();
        List<Book> recommendedBooks = facadeSearch.recommendBooks(userPreferences);
        System.out.println("Recommended Books:");
        displayBooks(recommendedBooks);
    }

    private static void searchBooks() {
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
    }

    private static void rateBook() {
        System.out.println("Enter the title of the book to rate:");
        String bookTitle = scanner.nextLine();
        List<Book> books = facadeSearch.searchByTitle(bookTitle);
        if (!books.isEmpty()) {
            Book book = books.get(0);
            System.out.println("Enter your rating (1 to 5):");
            int rating = scanner.nextInt();
            scanner.nextLine();
            book.addRating(rating);
            System.out.println("Rating added. Book now has an average rating of " + book.getAverageRating());
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void managePreferences() {
        System.out.println("Do you want to add favorite genres? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter favorite genre:");
            String genre = scanner.nextLine();
            facadePreferences.addFavoriteGenre(genre);
        }

        System.out.println("Do you want to add preferred authors? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter preferred author:");
            String author = scanner.nextLine();
            facadePreferences.addPreferredAuthor(author);
        }

        System.out.println("Do you want to add previously read books? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter previously read book:");
            String book = scanner.nextLine();
            facadePreferences.addPreviouslyReadBook(book);
        }
    }

    private static void savePreferences() {
        System.out.println("Enter the directory to save your preferences:");
        String saveDir = scanner.nextLine();
        System.out.println("Enter the filename to save your preferences:");
        String saveFile = scanner.nextLine();
        facadePreferences.savePreferences(saveDir, saveFile);
        System.out.println("Preferences saved.");
    }

    private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }
}
