package main.java.com.bookrec.model;

public class FictionBook extends Book {
    private String subgenre;
    
    public FictionBook(String title, String author, String genre, String subgenre) {
        super(title, author, genre);
        this.subgenre = subgenre;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Subgenre: " + subgenre);
        
    }
    
    public String getSubgenre() {
        return subgenre;
    }
}
