package main.java.com.bookrec.search;

import main.java.com.bookrec.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class BookSearch {
    private List<Book> books;
    private Map<String, List<Book>> booksByGenre;

    public BookSearch() {
        books = new ArrayList<>();
        booksByGenre = new HashMap<>();
        books.add(new FictionBook("Book1", "Author1", "Fiction", "Mystery", 4.0, List.of("Great mystery novel.")));
        books.add(new FictionBook("Book2", "Author2", "Fiction", "Thriller", 3.5, List.of("Good, but too predictable.")));
        books.add(new NonFictionBook("Book3", "Author3", "Non-Fiction", "History", 4.5, List.of("Very informative.")));
        books.add(new NonFictionBook("Book4", "Author4", "Non-Fiction", "Science", 2.0, List.of("Not very accurate.")));    
       }

    public void addBook(Book book) {
        books.add(book);
        booksByGenre.computeIfAbsent(book.getGenre().toLowerCase(), k -> new ArrayList<>()).add(book);
    }

    public List<Book> searchByGenre(String genre) {
        return booksByGenre.getOrDefault(genre.toLowerCase(), new ArrayList<>());
    }

    public List<Book> getBooks() {
        return books;
    }
}