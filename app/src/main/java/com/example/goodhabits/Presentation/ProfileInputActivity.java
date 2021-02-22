package com.example.goodhabits.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.goodhabits.Objects.Profile;
import com.example.goodhabits.Persistence.ProfileStorage;
import com.example.goodhabits.R;


public class ProfileInputActivity extends AppCompatActivity {

    // This can be toggled to skip the Create a Profile Screen
    // If true -> fills profile with fake data and goes directly to Main Screen
    // If false -> shows the Create a Profile Screen first
    boolean profileIsSet = true;

    @Override
    protected void onResume() {
        super.onResume();

        // If profileIsSet is true then fills profile with fake data and goes directly to Main Screen
        if(profileIsSet){
            ProfileStorage storage = new ProfileStorage();
            Profile profile = new Profile("Comp3350-Group12", "comp3350group12@gmail.com");
            storage.addToProfileStorage(profile);
            moveToMainActivity();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);

        // Title Bar text for this Activity
        setTitle("Create a Profile");

        // Button that validates Profile info, after being clicked
        Button done = (Button) findViewById(R.id.submit_profile);
        done.setOnClickListener(v -> validateForm());
    }

    // Helper function to move to Main Activity
    public void moveToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Function to validate the Profile form
    public void validateForm(){
        boolean pass = true;

        // Extracting the name given by the user
        EditText name = (EditText)findViewById(R.id.name_input);
        String nameString = name.getText().toString();

        // Extracting the email given by the user
        EditText email = (EditText)findViewById(R.id.email_input);
        String emailString = email.getText().toString();

        // Fire a toast message if both the input fields are empty
        if(nameString.equals("") && emailString.equals("")){
            Toast myToast = Toast.makeText(this, "Please enter your name and email address!", Toast.LENGTH_SHORT);
            myToast.show();
            pass = false;
        }
        // Fire a toast message if name field is empty
        if(nameString.equals("") && pass){
            Toast myToast = Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT);
            myToast.show();
            pass = false;
        }
        // Fire a toast message if email field is empty
        if(emailString.equals("") && pass){
            Toast myToast = Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT);
            myToast.show();
            pass = false;
        }
        // If all fields are filled, then store the Profile and go to Main Screen
        if(pass){
            ProfileStorage storage = new ProfileStorage();
            Profile profile = new Profile(nameString, emailString);
            storage.addToProfileStorage(profile);
            moveToMainActivity();
        }
    }
}
