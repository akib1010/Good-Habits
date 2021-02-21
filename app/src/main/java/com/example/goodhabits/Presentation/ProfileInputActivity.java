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

    boolean profileIsSet = true;

    @Override
    protected void onResume() {
        super.onResume();
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

        setTitle("Create a Profile");

        Button done = (Button) findViewById(R.id.submit_profile);
        done.setOnClickListener(v -> validateForm());
    }

    public void moveToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void validateForm(){
        boolean pass = true;

        EditText name = (EditText)findViewById(R.id.name_input);
        String nameString = name.getText().toString();

        EditText email = (EditText)findViewById(R.id.email_input);
        String emailString = email.getText().toString();

        if(nameString.equals("") && emailString.equals("")){
            Toast myToast = Toast.makeText(this, "Please enter your name and email address!", Toast.LENGTH_SHORT);
            myToast.show();
            pass = false;
        }
        if(nameString.equals("") && pass){
            Toast myToast = Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT);
            myToast.show();
            pass = false;
        }
        if(emailString.equals("") && pass){
            Toast myToast = Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT);
            myToast.show();
            pass = false;
        }
        if(pass){
            ProfileStorage storage = new ProfileStorage();
            Profile profile = new Profile(nameString, emailString);
            storage.addToProfileStorage(profile);
            moveToMainActivity();
        }
    }
}
