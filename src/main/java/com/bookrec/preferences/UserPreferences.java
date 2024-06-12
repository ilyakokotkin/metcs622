package main.java.com.bookrec.preferences;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); 
        out.writeObject(new ArrayList<>(favoriteGenres)); 
        out.writeObject(new ArrayList<>(preferredAuthors));
        out.writeObject(new ArrayList<>(previouslyReadBooks));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        favoriteGenres = new HashSet<>((List<String>) in.readObject()); 
        preferredAuthors = new HashSet<>((List<String>) in.readObject());
        previouslyReadBooks = new HashSet<>((List<String>) in.readObject());
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
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/koily/projects/METCS622/metcs622/" + directory + "/" + filename))) {
            return (UserPreferences) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Error loading user preferences: File not found");
        } catch (IOException e) {
            System.err.println("Error loading user preferences: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading user preferences: Class not found");
        }
        return new UserPreferences();
    }
}