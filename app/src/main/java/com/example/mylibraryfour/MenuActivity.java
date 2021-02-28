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
                Intent intentAll = new Intent(MenuActivity.this, AllBooksActivity.class);
                startActivity(intentAll);
            }
        });
        //TODO: need new classes. all btns shouldn't navigate to AllBooksActivity
        btnCurrentBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCurrent = new Intent(MenuActivity.this, AllBooksActivity.class);
                startActivity(intentCurrent);

            }
        });
        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFavorites = new Intent(MenuActivity.this, AllBooksActivity.class);
                startActivity(intentFavorites);
            }
        });
        btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWishlist = new Intent(MenuActivity.this, AllBooksActivity.class);
                startActivity(intentWishlist);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout = new Intent(MenuActivity.this, AllBooksActivity.class);
                startActivity(intentAbout);
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