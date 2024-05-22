package main.java.com.bookrec.facade;

import main.java.com.bookrec.preferences.UserPreferences;

public class FacadePreferences {
    private static final FacadePreferences instance = new FacadePreferences();
    private UserPreferences userPreferences;

    // Private constructor to prevent instantiation
    private FacadePreferences() {
        userPreferences = new UserPreferences();
    }

    // Method to get the singleton instance
    public static FacadePreferences getTheInstance() {
        return instance;
    }

    // Method to access functionality within the preferences package
    public void loadPreferences(String directory, String filename) {
        userPreferences = UserPreferences.loadFromFile(directory, filename);
    }

    public void savePreferences(String directory, String filename) {
        userPreferences.saveToFile(directory, filename);
    }

    public UserPreferences getUserPreferences() {
        return userPreferences;
    }

    public void addFavoriteGenre(String genre) {
        userPreferences.addFavoriteGenre(genre);
    }

    public void addPreferredAuthor(String author) {
        userPreferences.addPreferredAuthor(author);
    }

    public void addPreviouslyReadBook(String book) {
        userPreferences.addPreviouslyReadBook(book);
    }

    public void displayPreferences() {
        System.out.println("Favorite Genres: " + userPreferences.getFavoriteGenres());
        System.out.println("Preferred Authors: " + userPreferences.getPreferredAuthors());
        System.out.println("Previously Read Books: " + userPreferences.getPreviouslyReadBooks());
    }
}
