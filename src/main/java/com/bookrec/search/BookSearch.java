package main.java.com.bookrec.search;

import main.java.com.bookrec.model.*;
import java.util.ArrayList;
import java.util.List;

public class BookSearch {
    private List<Book> books;
    
    public BookSearch() {
        books = new ArrayList<>();
        books.add(new FictionBook("Book1", "Author1", "Fiction", "Mystery"));
        books.add(new FictionBook("Book2", "Author2", "Fiction", "Thriller"));
        books.add(new NonFictionBook("Book3", "Author3", "Non-Fiction", "History"));
        books.add(new NonFictionBook("Book4", "Author4", "Non-Fiction", "Science"));
    }
    
    public List<Book> searchByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
    
    public List<Book> searchByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
    
    public List<Book> searchByGenre(String genre) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
}
