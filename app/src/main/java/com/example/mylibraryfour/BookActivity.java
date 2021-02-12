package com.example.mylibraryfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private ImageView bookImage;
    private Button btnAddCurrentlyReading, btnAddWantRead, btnAddAlreadyRead, btnAddFavorites;
    private TextView nameText, txtBookName, authorText, txtAuthorName, pagesText, txtPages, descriptionText,
            txtDescription;
    public static final String BOOK_ID_KEY = "bookId";
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

        //passing default value as -1 since none of books in list will have -1
        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1){
                //3 security checks: checking intent is not null, make sure data received from intent, and checked if there is such a book in a list
                //ALWAYS CHECK FOR INTENT AND INTENT DATA
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                }
            }
        }
    }

    //getting alreadyreadbooks from utils class we are checking if book exists. if does, disables btn, if not setOnclick activates and adds to array list.
    public void handleAlreadyRead(Book book){
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        Boolean existingAlreadyReadBooks = false;
        for (Book b: alreadyReadBooks){
            if (b.getId() == book.getId()){
                existingAlreadyReadBooks = true;
            }
        }
        if (existingAlreadyReadBooks){
             btnAddAlreadyRead.setEnabled(false);

        }else{
            btnAddAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO: navigate user

                    }else{
                        Toast.makeText(BookActivity.this, "Book Could Not Be Added. Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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