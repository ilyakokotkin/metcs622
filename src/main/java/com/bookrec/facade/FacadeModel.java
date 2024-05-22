package main.java.com.bookrec.facade;

import main.java.com.bookrec.model.Book;
import main.java.com.bookrec.model.FictionBook;
import main.java.com.bookrec.model.NonFictionBook;

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
        // Example access: Creating books and displaying information
        Book fictionBook = new FictionBook("1984", "George Orwell", "Dystopian", "Political Fiction");
        Book nonFictionBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", "Non-Fiction", "History");

        fictionBook.displayInfo();
        nonFictionBook.displayInfo();
    }
}
