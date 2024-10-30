package com.example.mobileappdevfinalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;

public class LoginPage extends AppCompatActivity {

    Button loginSubmit;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginSubmit = findViewById(R.id.loginSubmit);
        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.passwordInput);
    }

    // onclick function
    public void loginSubmit(View view) {
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        // use a method in the database helper class to see if that combination of username/password exists
        // that method should return the ID of that person
        // int userId = dbHelper.checkUserInformation(usernameText, passwordText);
//        if (userId) {
//            Intent intent = new Intent(LoginPage.this, MainPage.class);
//        }
//        else {
//            // tell the user this person was not found.
//        }
    }
}