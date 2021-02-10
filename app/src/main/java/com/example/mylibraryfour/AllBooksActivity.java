package com.example.mylibraryfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        adapter = new BookRecViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecView);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();
        //check if adding a jpeg from the internet causes a crash
        books.add(new Book(1, "Dune", "Frank Herbert", 300, "https://images-na.ssl-images-amazon.com/images/I/91Fq9Amx0pL.jpg",
                "Test 1", "long description"));
        books.add(new Book(1, "book name", "author 2", 100, "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569__340.jpg",
                "Test 2", "Long Desc"));
        adapter.setBooks(books);
    }
}