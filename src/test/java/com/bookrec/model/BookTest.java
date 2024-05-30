package test.java.com.bookrec.model;

import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;
import org.junit.Test;
import java.util.Collections;  
import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void testFictionBook() {
        FictionBook fictionBook = new FictionBook(
            "Book1", 
            "Author1", 
            "Fiction", 
            "Mystery",
            0.0,  
            Collections.singletonList("No reviews")  
        );
        assertEquals("Book1", fictionBook.getTitle());
        assertEquals("Author1", fictionBook.getAuthor());
        assertEquals("Fiction", fictionBook.getGenre());
        assertEquals("Mystery", fictionBook.getSubgenre());
        assertEquals(0.0, fictionBook.getAverageRating(), 0.01);  
        assertEquals("No reviews", fictionBook.getReviews().get(0));  
    }
    
    @Test
    public void testNonFictionBook() {
        NonFictionBook nonFictionBook = new NonFictionBook(
            "Book2", 
            "Author2", 
            "Non-Fiction", 
            "History",
            0.0,  
            Collections.singletonList("No reviews")  
        );
        assertEquals("Book2", nonFictionBook.getTitle());
        assertEquals("Author2", nonFictionBook.getAuthor());
        assertEquals("Non-Fiction", nonFictionBook.getGenre());
        assertEquals("History", nonFictionBook.getSubject());
        assertEquals(0.0, nonFictionBook.getAverageRating(), 0.01);  
        assertEquals("No reviews", nonFictionBook.getReviews().get(0));  
    }
}
