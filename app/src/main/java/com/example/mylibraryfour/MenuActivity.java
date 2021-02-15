package com.example.mylibraryfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button btnAllBooks, btnCurrentBooks, btnReadBooks, btnWishList, btnFavorites, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initViews();
        //this is logic to navigate user to activities
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentBooks = findViewById(R.id.btnCurrentBooks);
        btnReadBooks = findViewById(R.id.btnReadBooks);
        btnWishList = findViewById(R.id.btnWishList);
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAbout = findViewById(R.id.btnAbout);
    }
}