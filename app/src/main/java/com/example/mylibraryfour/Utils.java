package com.example.mylibraryfour;

import java.util.ArrayList;

public class Utils {
    //implement singleton pattern: can add only instance of this class so it can interact with stack of array list.

    private static Utils instance;

    private Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            InitData();
        }
        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
    }

    private void InitData() {
        //TODO: add initial data
        ArrayList<Book> books = new ArrayList<>();
        //check if adding a jpeg from the internet causes a crash
        allBooks.add(new Book(1, "Dune", "Frank Herbert", 300, "https://images-na.ssl-images-amazon.com/images/I/91Fq9Amx0pL.jpg",
                "Test 1", "long description"));
        allBooks.add(new Book(2, "book name", "author 2", 100, "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569__340.jpg",
                "Test 2", "Long Desc"));
    }

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    //could use synchronized for multiple threads which will make methods thread safe (if diff threads called, called one by one)
    public static Utils getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils();
        }
        //TODO: this may not be necessary
        return null;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    //may need to remove null and modify the code
    public Book getBookById(int id) {
        for (Book b: allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }

        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }
}
