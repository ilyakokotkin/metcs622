package test.java.com.bookrec.model;

import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void testFictionBook() {
        FictionBook fictionBook = new FictionBook("Book1", "Author1", "Fiction", "Mystery");
        assertEquals("Book1", fictionBook.getTitle());
        assertEquals("Author1", fictionBook.getAuthor());
        assertEquals("Fiction", fictionBook.getGenre());
        assertEquals("Mystery", fictionBook.getSubgenre());
    }
    
    @Test
    public void testNonFictionBook() {
        NonFictionBook nonFictionBook = new NonFictionBook("Book2", "Author2", "Non-Fiction", "History");
        assertEquals("Book2", nonFictionBook.getTitle());
        assertEquals("Author2", nonFictionBook.getAuthor());
        assertEquals("Non-Fiction", nonFictionBook.getGenre());
        assertEquals("History", nonFictionBook.getSubject());
    }
}
