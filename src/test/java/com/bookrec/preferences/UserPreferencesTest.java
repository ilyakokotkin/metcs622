package test.java.com.bookrec.preferences;

import main.java.com.bookrec.preferences.UserPreferences;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class UserPreferencesTest {
    @Test
    public void testAddFavoriteGenre() {
        UserPreferences prefs = new UserPreferences();
        prefs.addFavoriteGenre("Fiction");
        List<String> favoriteGenres = prefs.getFavoriteGenres();
        assertEquals(1, favoriteGenres.size());
        assertEquals("Fiction", favoriteGenres.get(0));
    }
    
    @Test
    public void testAddPreferredAuthor() {
        UserPreferences prefs = new UserPreferences();
        prefs.addPreferredAuthor("Author1");
        List<String> preferredAuthors = prefs.getPreferredAuthors();
        assertEquals(1, preferredAuthors.size());
        assertEquals("Author1", preferredAuthors.get(0));
    }
    
    @Test
    public void testAddPreviouslyReadBook() {
        UserPreferences prefs = new UserPreferences();
        prefs.addPreviouslyReadBook("Book1");
        List<String> previouslyReadBooks = prefs.getPreviouslyReadBooks();
        assertEquals(1, previouslyReadBooks.size());
        assertEquals("Book1", previouslyReadBooks.get(0));
    }
}
