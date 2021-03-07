package com.example.goodhabits.Presentation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.goodhabits.Logic.DateParser;
import com.example.goodhabits.Logic.TimeParser;
import com.example.goodhabits.Objects.Habit;
import com.example.goodhabits.R;

import java.text.ParseException;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView name;
    TextView message;
    TextView notificationTime;
    TextView startDate;
    TextView endDate;
    TextView daysPassed;
    TextView checkins;
    ProgressBar progressBar;
    Button checkInButton;

    int index;
    Habit habit;
    DateParser dateParser = new DateParser();
    TimeParser timeParser = new TimeParser();
    MainActivity activity = new MainActivity();
    ArrayList<Habit> habitList = activity.habitStorage.getHabitList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent().getExtras() != null){
            index = (int) getIntent().getSerializableExtra("index");
            habit = habitList.get(index);

            name = (TextView) findViewById(R.id.dv_name);
            name.setText(habit.getHabitName());

            message = (TextView) findViewById(R.id.dv_message);
            message.setText(habit.getHabitMsg());

            notificationTime = (TextView) findViewById(R.id.dv_notification_time);
            String time = timeParser.getTime(habit.getHour(), habit.getMinute());
            notificationTime.setText(time);

            startDate = (TextView) findViewById(R.id.dv_start_date);
            startDate.setText(habit.getStartDate());

            endDate = (TextView) findViewById(R.id.dv_end_date);
            endDate.setText(habit.getEndDate());

            daysPassed = (TextView) findViewById(R.id.dv_days_passed);
            int days = 0;
            try {
                days = dateParser.getDaysPassed(habit.getStartDate(), dateParser.getTodaysDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            daysPassed.setText(String.valueOf(days));

            checkins = (TextView) findViewById(R.id.dv_checkins);
            checkins.setText(String.valueOf(habit.getDaysCheckedIn()));

            progressBar = (ProgressBar)findViewById(R.id.dv_progress_bar);
            progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#fbc263"), android.graphics.PorterDuff.Mode.SRC_IN);
            progressBar.setProgress(habit.getDaysCheckedIn());

            checkInButton = (Button) findViewById(R.id.dv_check_in_button);
            checkInButton.setOnClickListener(v -> increaseCheckIn());
        }

        else{
            System.out.println("ERROR: The Habit object was not passed to the Detail View.");
        }

        // Title Bar text for this Activity
        setTitle("Detail");

        // Tapping the back button on the Action Bar takes you to Home Screen
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    // Delegate function that recognises the tap on back button of this Activity
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void increaseCheckIn(){
        if (habit.getDaysCheckedIn() < 66){
            habit.increaseCheckIn();
            checkins.setText(String.valueOf(habit.getDaysCheckedIn()));
            progressBar.setProgress(habit.getDaysCheckedIn());
        }
    }
}
