package com.example.foodo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Initialize views
        EditText usernameField = findViewById(R.id.login_username);
        EditText passwordField = findViewById(R.id.login_password);
        Button loginButton = findViewById(R.id.login_btn);
        TextView signUpText = findViewById(R.id.donthaveanaccount_btn);
        ImageView googleButton = findViewById(R.id.google_btn);
        ImageView facebookButton = findViewById(R.id.facebook_btn);

        // Set click listener for Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignIn.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the user exists in the database
                    boolean isValidUser = dbHelper.checkUser(username, password);
                    if (isValidUser) {
                        Toast.makeText(SignIn.this, "Login successful", Toast.LENGTH_SHORT).show();
                        // Navigate to Dashboard and pass the username
                        Intent intent = new Intent(SignIn.this, Dashboard.class);
                        intent.putExtra("USERNAME", username); // Pass the username to Dashboard
                        startActivity(intent);
                        finish(); // Close the SignIn activity
                    } else {
                        Toast.makeText(SignIn.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set click listener for Sign Up text
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });

        // Set click listener for Google button
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(browserIntent);
            }
        });

        // Set click listener for Facebook button
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(browserIntent);
            }
        });
    }
}