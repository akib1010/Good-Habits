package com.example.goodhabits.Presentation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.goodhabits.Objects.Profile;
import com.example.goodhabits.Persistence.ProfileStorage;
import com.example.goodhabits.R;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Title Bar text for this Activity
        setTitle("Profile");

        // Tapping the back button on the Action Bar takes you to Home Screen
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ArrayList<Profile> list = ProfileStorage.getProfileStorage(); // getting the non-persistent profile info
        String[] profileInfo = {list.get(0).getName(), list.get(0).getEmail()}; // putting the info in a String array
        fillProfileActivity(profileInfo);
    }

    // Function to populate all the Name and Email TextViews in this Activity
    public void fillProfileActivity(String [] profileInfo){
        TextView name = (TextView)findViewById(R.id.name_view);
        name.setText(profileInfo[0]);

        TextView email = (TextView)findViewById(R.id.email_view);
        email.setText(profileInfo[1]);
    }

    // Delegate function that recognises the tap on back button of this Activity
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
