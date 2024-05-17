package main.java.com.bookrec.preferences;

import java.util.ArrayList;
import java.util.List;

public class UserPreferences {
    private List<String> favoriteGenres;
    private List<String> preferredAuthors;
    private List<String> previouslyReadBooks;
    
    public UserPreferences() {
        favoriteGenres = new ArrayList<>();
        preferredAuthors = new ArrayList<>();
        previouslyReadBooks = new ArrayList<>();
    }
    
    public void addFavoriteGenre(String genre) {
        favoriteGenres.add(genre);
    }
    
    public void addPreferredAuthor(String author) {
        preferredAuthors.add(author);
    }
    
    public void addPreviouslyReadBook(String book) {
        previouslyReadBooks.add(book);
    }
    
    public List<String> getFavoriteGenres() {
        return favoriteGenres;
    }
    
    public List<String> getPreferredAuthors() {
        return preferredAuthors;
    }
    
    public List<String> getPreviouslyReadBooks() {
        return previouslyReadBooks;
    }
}