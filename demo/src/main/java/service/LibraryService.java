package service;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Books in library:");
        for (Book b : books) {
            String status = b.isIssued() ? "Issued" : "Available";
            System.out.println(b.getId() + " - " + b.getTitle() + " by " + b.getAuthor() + " [" + status + "]");
        }
    }

    public void issueBook(String bookId) {
        for (Book b : books) {
            if (b.getId().equals(bookId)) {
                if (!b.isIssued()) {
                    b.setIssued(true);
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String bookId) {
        for (Book b : books) {
            if (b.getId().equals(bookId)) {
                if (b.isIssued()) {
                    b.setIssued(false);
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

