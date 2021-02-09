package com.example.mylibraryfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Book> books = new ArrayList<>();
        //check if adding a jpeg from the internet causes a crash
        books.add(new Book(1, "Dune", "Frank Herbert", 300, "https://images-na.ssl-images-amazon.com/images/I/91Fq9Amx0pL.jpg",
                "space odyssey", "long description"));
        adapter.setBooks(books);
    }
}