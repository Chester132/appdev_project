package com.example.foodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        TextView welcomeText = findViewById(R.id.welcome_text);
        ImageView notificationIcon = findViewById(R.id.notification_icon);
        CardView donateCard = findViewById(R.id.donate);
        CardView receiveCard = findViewById(R.id.receive);
        CardView foodMapCard = findViewById(R.id.foodmap);
        CardView marketsCard = findViewById(R.id.markets);
        ImageView homeIcon = findViewById(R.id.home_icon);
        ImageView foodCenterIcon = findViewById(R.id.foodcenter_icon);
        ImageView educationalResourcesIcon = findViewById(R.id.educationalresources_icon);
        ImageView settingsIcon = findViewById(R.id.settings_icon);


        // Retrieve the username from the Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        // Display the welcome message with the username
        if (username != null && !username.isEmpty()) {
            welcomeText.setText("Welcome, " + username + "!");
        } else {
            welcomeText.setText("Welcome, User!");
        }

        // set click listener for Home Icon
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });
        // Set click listener for Notification Icon
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to NotificationsActivity
                Intent intent = new Intent(Dashboard.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Donate Card
        donateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to DonateActivity
                Intent intent = new Intent(Dashboard.this, DonateActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Receive Card
        receiveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ReceiveActivity
                Intent intent = new Intent(Dashboard.this, ReceiveActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Food Map Card
        foodMapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to FoodMapActivity
                Intent intent = new Intent(Dashboard.this, FoodMapActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Markets Card
        marketsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MarketsActivity
                Intent intent = new Intent(Dashboard.this, MarketsActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Home Icon
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HomeActivity (or Dashboard if already on Dashboard)
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });

        // Set click listener for Food Center Icon
        foodCenterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to FoodCenterActivity
                Intent intent = new Intent(Dashboard.this, FoodCenterActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Educational Resources Icon
        educationalResourcesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to EducationalResourcesActivity
                Intent intent = new Intent(Dashboard.this, EducationalResourcesActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Settings Icon
        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SettingsActivity
                Intent intent = new Intent(Dashboard.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}