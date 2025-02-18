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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Initialize views
        EditText usernameField = findViewById(R.id.login_username);
        EditText emailField = findViewById(R.id.login_email);
        EditText passwordField = findViewById(R.id.login_password);
        EditText reEnterPasswordField = findViewById(R.id.login_reenterpassword);
        Button signUpButton = findViewById(R.id.signupbutton);
        TextView alreadyHaveAccountText = findViewById(R.id.alreadyhaveanaccount_btn);
        ImageView googleButton = findViewById(R.id.google_btn);
        ImageView facebookButton = findViewById(R.id.facebook_btn);

        // Set click listener for Sign Up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString().trim();
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();
                String reEnterPassword = reEnterPasswordField.getText().toString().trim();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || reEnterPassword.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(reEnterPassword)) {
                    Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert user data into the database
                    boolean isInserted = dbHelper.addUser(username, email, password);
                    if (isInserted) {
                        // Show success pop-up
                        showSuccessPopup();
                    } else {
                        Toast.makeText(SignUp.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set click listener for Already Have Account text
        alreadyHaveAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
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

    // Method to show a success pop-up
    private void showSuccessPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Account Created");
        builder.setMessage("Your account has been successfully created!");
        builder.setPositiveButton("OK", (dialog, which) -> {
            // Navigate to SignIn activity after the user clicks "OK"
            Intent intent = new Intent(SignUp.this, SignIn.class);
            startActivity(intent);
            finish(); // Close the SignUp activity
        });
        builder.setCancelable(false); // Prevent the user from dismissing the dialog by tapping outside
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}