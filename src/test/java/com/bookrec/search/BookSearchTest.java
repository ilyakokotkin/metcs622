package test.java.com.bookrec.search;

import main.java.com.bookrec.model.Book;
import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;
import main.java.com.bookrec.search.BookSearch;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class BookSearchTest {
    private BookSearch bookSearch;

    @Before
    public void setUp() {
        bookSearch = new BookSearch();
    }

    @Test
    public void testAddBook() {
        // Start with an empty BookSearch to test addition of books
        BookSearch newBookSearch = new BookSearch();
        assertEquals(0, newBookSearch.getBooks().size());

        FictionBook newBook = new FictionBook("Book5", "Author5", "Fiction", "Romance", 5.0, List.of("Loved the storyline!"));
        newBookSearch.addBook(newBook);
        assertEquals(1, newBookSearch.getBooks().size());
        assertEquals("Book5", newBookSearch.getBooks().get(0).getTitle());
    }

    @Test
    public void testSearchByGenre() {
        List<Book> fictionBooks = bookSearch.searchByGenre("fiction");
        assertNotNull(fictionBooks);
        assertEquals(2, fictionBooks.size()); 

        // Check that all books returned have the genre "Fiction"
        assertTrue(fictionBooks.stream().allMatch(book -> book.getGenre().equalsIgnoreCase("fiction")));
    }

    @Test
    public void testGetBooks() {
        List<Book> allBooks = bookSearch.getBooks();
        assertNotNull(allBooks);
        assertEquals(4, allBooks.size()); 
    }
}
