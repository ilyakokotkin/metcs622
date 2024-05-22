package main.java.com.bookrec.facade;

import main.java.com.bookrec.search.BookSearch;
import main.java.com.bookrec.model.Book;
import java.util.List;

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

    // Method to access functionality within the search package
    public List<Book> searchByTitle(String title) {
        return bookSearch.searchByTitle(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookSearch.searchByAuthor(author);
    }

    public List<Book> searchByGenre(String genre) {
        return bookSearch.searchByGenre(genre);
    }

    public void addBook(Book book) {
        bookSearch.addBook(book);
    }
}
