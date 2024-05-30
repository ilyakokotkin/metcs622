package main.java.com.bookrec.model;

import java.util.List;

public class FictionBook extends Book {
    private String subgenre;
    
    // Updated constructor to include ratings and reviews initialization
    public FictionBook(String title, String author, String genre, String subgenre, double averageRating, List<String> reviews) {
        super(title, author, genre);  
        this.subgenre = subgenre;
        this.averageRating = averageRating;  
        this.reviews = reviews;  
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + getGenre());
        System.out.println("Subgenre: " + subgenre);
        System.out.println("Average Rating: " + getAverageRating());
        System.out.println("Reviews:");
        for (String review : getReviews()) {
            System.out.println("- " + review);
        }
    }

    public String getSubgenre() {
        return subgenre;
    }
}
