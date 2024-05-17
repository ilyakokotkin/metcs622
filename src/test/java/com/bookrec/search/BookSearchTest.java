package test.java.com.bookrec.search;

import main.java.com.bookrec.model.Book;
import main.java.com.bookrec.search.BookSearch;
import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;
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
    public void testSearchByTitle() {
        List<Book> results = bookSearch.searchByTitle("Book1");
        assertEquals(1, results.size());
        assertEquals("Book1", results.get(0).getTitle());
    }
    
    @Test
    public void testSearchByAuthor() {
        List<Book> results = bookSearch.searchByAuthor("Author1");
        assertEquals(1, results.size());
        assertEquals("Author1", results.get(0).getAuthor());
    }
    
    @Test
    public void testSearchByGenre() {
        List<Book> results = bookSearch.searchByGenre("Non-Fiction");
        assertEquals(2, results.size());
        assertTrue(results.stream().allMatch(book -> book.getGenre().equals("Non-Fiction")));
    }
}
