package main.java.com.bookrec.model;

public class NonFictionBook extends Book {
    private String subject;
    
    public NonFictionBook(String title, String author, String genre, String subject) {
        super(title, author, genre);
        this.subject = subject;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Subject: " + subject);
    }
    
    public String getSubject() {
        return subject;
    }
}
