package com.example.goodhabits.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.goodhabits.Objects.Habit;
import com.example.goodhabits.Persistence.HabitStorage;
import com.example.goodhabits.Persistence.ProfileStorage;
import com.example.goodhabits.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Creating non-persistence storage for Habit and Profile Objects
    HabitStorage habitStorage = new HabitStorage();
    ProfileStorage profileStorage = new ProfileStorage();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume(){
        super.onResume();

        // Fake data to populate the List view
        // More Habits can be added to this List View by going to the Add a Habit Screen and creating a new Habit
        if(habitStorage.getHabitStorageSize() == 0) {
            habitStorage.addToHabitStorage(new Habit("Quit Smoking", false, "Smoking causes Cancer.", 11, 30));
            habitStorage.addToHabitStorage(new Habit("Do Yoga", true, "Need to stay fit.", 8, 0));
            habitStorage.addToHabitStorage(new Habit("Drink Water", true, "Need to hydrate my body.", 10, 30));
        }

        // Updating the Total Habits count
        TextView habitCount = (TextView) findViewById(R.id.habit_count_view);
        habitCount.setText(Integer.toString(habitStorage.getHabitStorageSize()));
    }

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

        // Clicking this button takes you to the Settings Screen
        ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(v -> openSettingsActivity());

        // Clicking this button takes you to the Add Habit Screen
        ImageButton add = (ImageButton) findViewById(R.id.add_button);
        add.setOnClickListener(v -> openAddActivity());

        // Clicking this button takes you to the Screen with all the Habits created
        ImageButton allHabits = (ImageButton) findViewById(R.id.all_habits_button);
        allHabits.setOnClickListener(v -> openAllHabitsActivity());

        // Clicking this button takes you to the User's Profile Screen
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
