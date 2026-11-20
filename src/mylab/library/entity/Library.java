package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private String name;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if(book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getAuthor().equals(author))
                foundBooks.add(book);
        }
        return foundBooks;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if(book.getIsbn().equals(isbn))
                return book;
        }
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book bookByISBN = findBookByISBN(isbn);

        if(bookByISBN == null) { // 책이 존재하지 않는다.
            return false;
        } else if(bookByISBN.isAvailable()) {
            bookByISBN.checkOut();
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(String isbn) {
        Book bookByISBN = findBookByISBN(isbn);
        if(bookByISBN == null) { // 책이 존재하지 않는다.
            return false;
        }
        bookByISBN.returnBook();
        return true;
    }

    public List<Book> getAvailableBooks() {
        List<Book> books1 = new ArrayList<>();
        for (Book book : books) {
            if(book.isAvailable())
                books1.add(book);
        }
        return  books1;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooks().size();
    }

}
