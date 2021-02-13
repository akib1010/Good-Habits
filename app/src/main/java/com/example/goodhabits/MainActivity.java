package com.example.goodhabits;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To remove the default Title Bar of this Activity
        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException e) {
            System.out.println("Title bar of main screen could not be removed.");
        }

        ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(v -> openSettingsActivity());

        ImageButton add = (ImageButton) findViewById(R.id.add_button);
        add.setOnClickListener(v -> openAddActivity());

        ImageButton allHabits = (ImageButton) findViewById(R.id.all_habits_button);
        allHabits.setOnClickListener(v -> openAllHabitsActivity());

        ImageButton profile = (ImageButton) findViewById(R.id.user_profile_button);
        profile.setOnClickListener(v -> openProfileActivity());
    }

    public void openSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openAddActivity(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void openAllHabitsActivity(){
        Intent intent = new Intent(this, AllHabitsActivity.class);
        startActivity(intent);
    }

    public void openProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
