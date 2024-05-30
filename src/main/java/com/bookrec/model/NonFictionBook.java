package main.java.com.bookrec.model;

import java.util.List;

public class NonFictionBook extends Book {
    private String subject;
    
    // Updated constructor to include ratings and reviews initialization
    public NonFictionBook(String title, String author, String genre, String subject, double averageRating, List<String> reviews) {
        super(title, author, genre); 
        this.subject = subject;
        this.averageRating = averageRating;  
        this.reviews = reviews;  
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + getGenre());
        System.out.println("Subject: " + subject);
        System.out.println("Average Rating: " + getAverageRating());
        System.out.println("Reviews:");
        for (String review : getReviews()) {
            System.out.println("- " + review);
        }
    }
    
    public String getSubject() {
        return subject;
    }
}
