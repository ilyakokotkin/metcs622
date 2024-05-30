package main.java.com.bookrec.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Book {
    protected String title;
    protected String author;
    protected String genre;
    protected List<String> reviews;
    protected double averageRating;
    protected int ratingCount;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.reviews = new ArrayList<>();
        this.averageRating = 0.0;
        this.ratingCount = 0;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public void addRating(int rating) {
        averageRating = (averageRating * ratingCount + rating) / (++ratingCount);
    }

    public abstract void displayInfo();

    public List<String> getReviews() {
        return reviews;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
