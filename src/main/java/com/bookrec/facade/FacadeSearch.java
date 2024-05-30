package main.java.com.bookrec.facade;

import main.java.com.bookrec.search.BookSearch;
import main.java.com.bookrec.model.Book;
import java.util.List;
import java.util.stream.Collectors;

public class FacadeSearch {
    private static final FacadeSearch instance = new FacadeSearch();
    private BookSearch bookSearch;

    // Private constructor to prevent instantiation
    private FacadeSearch() {
        bookSearch = new BookSearch();
    }

    
    // Method to get the singleton instance
    public static FacadeSearch getTheInstance() {
        return instance;
    }

    // Existing search methods
    public List<Book> searchByTitle(String title) {
        return bookSearch.getBooks().stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
    }

    // New method to search books by minimum rating
    public List<Book> searchByMinimumRating(double minRating) {
        return bookSearch.getBooks().stream()
                    .filter(book -> book.getAverageRating() >= minRating)
                    .collect(Collectors.toList());
    }
}
