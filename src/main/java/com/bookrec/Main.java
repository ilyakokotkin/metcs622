package main.java.com.bookrec;

import main.java.com.bookrec.model.*;
import main.java.com.bookrec.preferences.*;
import main.java.com.bookrec.search.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserPreferences preferences = new UserPreferences();
        // Prompt user for reading preferences
        preferences.addFavoriteGenre("Fiction");
        preferences.addPreferredAuthor("Author1");
        preferences.addPreviouslyReadBook("Book2");
        
        BookSearch bookSearch = new BookSearch();
        
        // Allow user to perform book searches
        List<Book> titleResults = bookSearch.searchByTitle("Book1");
        List<Book> authorResults = bookSearch.searchByAuthor("Author3");
        List<Book> genreResults = bookSearch.searchByGenre("Non-Fiction");
        
        // Display search results
        System.out.println("Search Results by Title:");
        displayBooks(titleResults);
        System.out.println("\nSearch Results by Author:");
        displayBooks(authorResults);
        System.out.println("\nSearch Results by Genre:");
        displayBooks(genreResults);
    }
    
    private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }
}