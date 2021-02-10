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
        String longDesc = "Dune is set in the distant future amidst a feudal " +
                "\ninterstellar society in which various noble houses control " +
                "\nplanetary fiefs. It tells the story of young Paul Atreides, " +
                "\nwhose family accepts the stewardship of the planet Arrakis. " +
                "\nWhile the planet is an inhospitable and sparsely populated " +
                "\ndesert wasteland, it is the only source of melange, or the spice," +
                "\na drug that extends life and enhances mental abilities. " +
                "\nMelange is also necessary for space navigation, which requires" +
                "\na kind of multidimensional awareness and foresight that only" +
                "\nthe drug provides. As melange can only be produced on Arrakis," +
                "\ncontrol of the planet is thus a coveted and dangerous " +
                "\nundertaking. The story explores the multi-layered interactions " +
                "\nof politics, religion, ecology, technology, and human emotion, " +
                "\nas the factions of the empire confront each other in a struggle" +
                "\nfor the control of Arrakis and its spice.";
        //TODO: get data from recview
        Book book = new Book(1, "Dune", "Frank Herbert", 300, "https://images-na.ssl-images-amazon.com/images/I/91Fq9Amx0pL.jpg",
                "Test 1", longDesc);
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