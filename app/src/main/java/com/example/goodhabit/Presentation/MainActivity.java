package com.example.goodhabit.Presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.goodhabit.Application.Services;
import com.example.goodhabit.Logic.HabitManager;
import com.example.goodhabit.Objects.Habit;
import com.example.goodhabit.Persistence.DBUtils;
import com.example.goodhabit.Persistence.HabitStorage;
import com.example.goodhabit.Persistence.ProfileStorage;
import com.example.goodhabit.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Creating non-persistence storage for Habit and Profile Objects
    HabitStorage habitStorage = new HabitStorage();
    ProfileStorage profileStorage = new ProfileStorage();

    private HabitManager hm;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume(){
        super.onResume();

        // Fake data to populate the List view
        // More Habits can be added to this List View by going to the Add a Habit Screen and creating a new Habit
        if(habitStorage.getHabitListSize() == 0) {
            try {
                String startDate = "13/03/2020";
                String endDate = "18/08/2021";
                habitStorage.addHabit(new Habit(1,"Quit Smoking", false, "Smoking causes Cancer.", 11, 30, startDate, endDate, 0));
                habitStorage.addHabit(new Habit(2,"Do Yoga", true, "Need to stay fit.", 8, 0, startDate, endDate, 0));
                habitStorage.addHabit(new Habit(3,"Drink Water", true, "Need to hydrate my body.", 10, 30, startDate, endDate, 0));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        // Updating the Total Habits count
        TextView habitCount = (TextView) findViewById(R.id.habit_count_view);
        habitCount.setText(Integer.toString(habitStorage.getHabitListSize()));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBUtils.copyDatabaseToDevice(this);
        hm = new HabitManager(Services.getHabitStorage());
        Habit habit = new Habit(24, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05, 05,2021", 10);
        System.out.println(hm.addHabit(habit));


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
