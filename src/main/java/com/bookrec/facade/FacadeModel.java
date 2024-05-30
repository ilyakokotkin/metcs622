package main.java.com.bookrec.facade;

import main.java.com.bookrec.model.Book;
import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;
import java.util.Collections;

public class FacadeModel {
    private static final FacadeModel instance = new FacadeModel();

    // Private constructor to prevent instantiation
    private FacadeModel() {}

    // Method to get the singleton instance
    public static FacadeModel getTheInstance() {
        return instance;
    }

    // Method to access functionality within the model package
    public void myPackageAccess() {
        // Correctly creating books with a list of reviews
        Book fictionBook = new FictionBook(
            "1984", 
            "George Orwell", 
            "Dystopian", 
            "Political Fiction", 
            0.0, 
            Collections.singletonList("No reviews yet")  // Using Collections.singletonList to create a single-item list
        );
        Book nonFictionBook = new NonFictionBook(
            "Sapiens", 
            "Yuval Noah Harari", 
            "Non-Fiction", 
            "History", 
            0.0, 
            Collections.singletonList("No reviews yet")  // Same as above
        );

        fictionBook.displayInfo();
        nonFictionBook.displayInfo();
    }
}
