package comp3350.goodhabits.Presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import comp3350.goodhabits.Application.App;
import comp3350.goodhabits.Logic.HabitManager;
import comp3350.goodhabits.Logic.Notifier;
import comp3350.goodhabits.Logic.QuoteManager;
import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Persistence.SQLite.HabitSQLite;
import comp3350.goodhabits.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    QuoteManager quoteManager;
    TextView quote;
    private String quoteText = "";
    private int count = 1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume(){
        super.onResume();

        // Manager for Persistent Habit Storage
        new HabitManager(new HabitSQLite(this));
        new Notifier(MainActivity.this);

        // Manager for Non-Persistent Habit Storage
        // new HabitManager(new HabitStorage());

        if(HabitManager.getHabitListSize() == 0){
            HabitManager.addHabit(new Habit(1,"Quit Smoking", false, "Smoking causes Cancer.", 11, 30, "13/03/2020", "18/05/2020", 35));
            HabitManager.addHabit(new Habit(2,"Drink Water", true, "Need to hydrate my body.", 10, 30, "13/03/2020", "18/05/2020", 54));
            HabitManager.addHabit(new Habit(3,"Do Yoga", true, "Need to stay fit.", 8, 0, "01/04/2021", "06/06/2021", 2));
        }

        quoteManager = new QuoteManager(this);
        if(count == 1) {
            quoteText = quoteManager.getQuote();
            count += 1;
        }

        sharedPreferences = getSharedPreferences("QuoteSharedPref", Context.MODE_PRIVATE);
        String state = sharedPreferences.getString("state", "");

        quote = (TextView) findViewById(R.id.quote);
        if(state.equals("off")){
            quote.setText("");
        }
         else{
            quote.setText(quoteText);
        }

        // Updating the Total Habits count
        TextView habitCount = (TextView) findViewById(R.id.habit_count_view);
        habitCount.setText(Integer.toString(HabitManager.getHabitListSize()));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

    public void setContext(){
        App.setContext(this);
    }
}
