package test.java.com.bookrec.preferences;

import main.java.com.bookrec.preferences.UserPreferences;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Set;

public class UserPreferencesTest {
    @Test
    public void testAddFavoriteGenre() {
        UserPreferences prefs = new UserPreferences();
        prefs.addFavoriteGenre("Fiction");
        Set<String> favoriteGenres = prefs.getFavoriteGenres();
        assertTrue(favoriteGenres.contains("Fiction"));
        assertEquals(1, favoriteGenres.size());
    }

    @Test
    public void testAddPreferredAuthor() {
        UserPreferences prefs = new UserPreferences();
        prefs.addPreferredAuthor("Author1");
        Set<String> preferredAuthors = prefs.getPreferredAuthors();
        assertTrue(preferredAuthors.contains("Author1"));
        assertEquals(1, preferredAuthors.size());
    }

    @Test
    public void testAddPreviouslyReadBook() {
        UserPreferences prefs = new UserPreferences();
        prefs.addPreviouslyReadBook("Book1");
        Set<String> previouslyReadBooks = prefs.getPreviouslyReadBooks();
        assertTrue(previouslyReadBooks.contains("Book1"));
        assertEquals(1, previouslyReadBooks.size());
    }
}
