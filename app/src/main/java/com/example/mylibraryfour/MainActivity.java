package com.example.mylibraryfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText txtName, txtEmail, txtPassword, txtPasswordReenter;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale, rbOther;
    private CheckBox chkAgree;
    private Button btnRegister, btnImage;
    private Spinner spinnerCountries;
    private TextView txtNameWarn, txtEmailWarn, txtPasswordWarn, txtPasswordReenterWarn;
    private ConstraintLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all UI elements
        initViews();


        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "image button", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }

        });
    }
    //checks if user has entered all the relevant data
    private void initRegister() {
        if (validateData()) {
            btnRegister.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //TODO: intent takes two args. make sure it directs to books menu
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


    //TODO: modify this to go to main activity (books menu)


    //ensures that btnRegister will work only if all relevant info are inputted correctly
    private boolean validateData() {
        Log.d(TAG, "initRegister");
        if (txtName.getText().toString().equals("")) {
            txtNameWarn.setVisibility(View.VISIBLE);
            txtNameWarn.setText("Please Enter your name");
            return false;
        }
        if (txtEmail.getText().toString().equals("")) {
            txtEmailWarn.setVisibility(View.VISIBLE);
            txtEmailWarn.setText("Please enter your email");
            return false;
        }
        if (txtPassword.getText().toString().equals("")) {
            txtPasswordWarn.setVisibility(View.VISIBLE);
            txtPasswordWarn.setText("please enter your password");
            return false;
        }
        if (txtPasswordReenter.getText().toString().equals("")) {
            txtPasswordReenterWarn.setVisibility(View.VISIBLE);
            txtPasswordReenterWarn.setText("Please reenter your password");
            return false;
        }
        if (chkAgree.isChecked() == false){
            Toast.makeText(MainActivity.this, "Please agree to the terms", Toast.LENGTH_LONG).show();
            return false;
        }
        if (txtPassword.getText().toString().equals(txtPasswordReenter.getText().toString()) == false) {
            Toast.makeText(this, "MAKE SURE THE PASSWORDS MATCH!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    //all views set to be initialized including setting spinner adapter
    private void initViews () {
        Log.d(TAG, "initViews: Started");
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtPasswordReenter = findViewById(R.id.txtPasswordReenter);

        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);

        chkAgree = findViewById(R.id.chkAgree);

        btnImage = findViewById(R.id.btnImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtNameWarn = findViewById(R.id.txtNameWarn);
        txtEmailWarn = findViewById(R.id.txtEmailWarn);
        txtPasswordWarn = findViewById(R.id.txtPasswordWarn);
        txtPasswordReenterWarn = findViewById(R.id.txtPasswordReenterWarn);

        /*spinnerCountries = findViewById(R.id.spinnerCountries);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                //TODO: array resource value inserted. test for bugs
                R.array.spinnerCountries, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerCountries.setAdapter(adapter);
        parent = findViewById(R.id.parent);

        parent = findViewById(R.id.parent);
*/
    }

}