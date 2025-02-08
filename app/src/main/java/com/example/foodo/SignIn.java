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
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

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
                    // Perform login logic here (e.g., authenticate with a server or database)
                    Toast.makeText(SignIn.this, "Login successful", Toast.LENGTH_SHORT).show();
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
