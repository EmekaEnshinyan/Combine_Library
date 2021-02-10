package com.example.mylibraryfour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {
    private ImageView bookImage;
    private Button btnAddCurrentlyReading, btnAddWantRead, btnAddAlreadyRead, btnAddFavorites;
    private TextView nameText, txtBookName, authorText, txtAuthorName, pagesText, txtPages, descriptionText,
            txtDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        InitViews();
        //TODO: get data from recview
        Book book = new Book(1, "Dune", "Frank Herbert", 300, "https://images-na.ssl-images-amazon.com/images/I/91Fq9Amx0pL.jpg",
                "Test 1", "long description");
        setData(book);

    }

    private void InitViews(){
        bookImage = findViewById(R.id.imgBook);

        btnAddCurrentlyReading = findViewById(R.id.btnAddCurrentlyReading);
        btnAddWantRead = findViewById(R.id.btnAddWantRead);
        btnAddAlreadyRead = findViewById(R.id.btnAddAlreadyRead);
        btnAddFavorites = findViewById(R.id.btnAddFavorites);

        nameText = findViewById(R.id.nameText);
        txtBookName = findViewById(R.id.txtBookName);
        authorText = findViewById(R.id.authorText);
        txtAuthorName = findViewById(R.id.txtAuthorName);
        pagesText = findViewById(R.id.pagesText);
        txtPages = findViewById(R.id.txtPages);
        descriptionText = findViewById(R.id.descriptionText);
        txtDescription = findViewById(R.id.txtDescription);
    }

    private void setData(Book book){
        txtBookName.setText(book.getName());
        txtAuthorName.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);


    }
}