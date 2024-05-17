package main.java.com.bookrec.preferences;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserPreferences implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error saving user preferences: " + e.getMessage());
        }
    }

    public static UserPreferences loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (UserPreferences) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading user preferences: " + e.getMessage());
            return new UserPreferences();
        }
    }
}
