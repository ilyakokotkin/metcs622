package main.java.com.bookrec.preferences;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class UserPreferences implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<String> favoriteGenres;
    private Set<String> preferredAuthors;
    private Set<String> previouslyReadBooks;

    public UserPreferences() {
        favoriteGenres = new HashSet<>();
        preferredAuthors = new HashSet<>();
        previouslyReadBooks = new HashSet<>();
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

    public Set<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public Set<String> getPreferredAuthors() {
        return preferredAuthors;
    }

    public Set<String> getPreviouslyReadBooks() {
        return previouslyReadBooks;
    }

    public void saveToFile(String directory, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/koily/projects/METCS622/metcs622/" + directory + "/" + filename))) {
            oos.writeObject(this);
            System.out.println("Preferences saved to file: " + directory + "/" + filename);
        } catch (IOException e) {
            System.err.println("Error saving user preferences: " + e.getMessage());
        }
    }

    public static UserPreferences loadFromFile(String directory, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/koily/projects/METCS622/metcs622/" + directory + "/" + filename))) {
            UserPreferences preferences = new UserPreferences();
            String line;
    
            // Read favorite genres
            if ((line = br.readLine()) != null) {
                preferences.favoriteGenres = new HashSet<>(Arrays.asList(line.split(",")));
            }
    
            // Read preferred authors
            if ((line = br.readLine()) != null) {
                preferences.preferredAuthors = new HashSet<>(Arrays.asList(line.split(",")));
            }
    
            // Read previously read books
            if ((line = br.readLine()) != null) {
                preferences.previouslyReadBooks = new HashSet<>(Arrays.asList(line.split(",")));
            }
    
            return preferences;
        } catch (FileNotFoundException e) {
            System.err.println("Error loading user preferences: File not found");
        } catch (IOException e) {
            System.err.println("Error loading user preferences: " + e.getMessage());
        }
        return new UserPreferences();
    }
}