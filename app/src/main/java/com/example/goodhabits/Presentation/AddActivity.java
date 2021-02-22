package com.example.goodhabits.Presentation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.goodhabits.Objects.Habit;
import com.example.goodhabits.Persistence.HabitStorage;
import com.example.goodhabits.R;


// This Class helps create a new Habit
public class AddActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    private String name;
    private RadioGroup typeGroup;
    private RadioButton type;
    private String msg;
    private int hour = -1; // Initialized to -1
    private int minute = -1; // Initialized to -1
    private boolean toastFired = false; // Used to check if any toast messages were shown
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        
        // Contexts of the form that need to be stored
        EditText habitName;
        EditText habitMsg;
        Button timeButton;
        Button submitButton;

        // Title Bar text for this Activity
        setTitle("Add a Habit");

        // Tapping the back button on the Action Bar takes you to Home Screen
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get the name of the Habit when it is Written
        habitName = findViewById(R.id.habit_name_input);

        // Tapping a RadioButton to determine type of Habit
        typeGroup = findViewById(R.id.habit_type_group);
        typeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                type = findViewById(id); // Assign the new selected button to type
            }
        });

        // When the User message is written
        habitMsg = findViewById(R.id.habit_message_input);

        // Tapping the Time Picker Button to select a time for the activity regarding the habit
        timeButton = findViewById(R.id.time_picker);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });

        // Tapping the "Submit" Button on the addHabit form
        submitButton = findViewById(R.id.submit_habit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastFired = false; // This boolean value is used to check if any toast messages are give
                name = habitName.getText().toString(); // Get the name of the habit

                // Get the typeGroup selected (If the user does not click on the RadioButtons)
                int radioId = typeGroup.getCheckedRadioButtonId();
                type = findViewById(radioId);

                msg = habitMsg.getText().toString(); // Get the User message

                checkToaster(); // Check for toast message

                // If any Toast message is NOT displayed
                if(!toastFired) {
                    Habit newHabit = createHabit(name,type,msg,hour,minute); // Create a Habit
                    addHabit(newHabit); // Add the Habit to the list of Habits
                    startActivity(new Intent(AddActivity.this, MainActivity.class)); // Go to the main screen
                }
            }
        });
    }

    // This Function finds the RadioButton that is selected by the user
    public void selectedButton(View v)
    {
        int radioId = typeGroup.getCheckedRadioButtonId();   // Get the ID of the selected button
        type = findViewById(radioId); // Assign it to our RadioButton Variable
    }

    // This Function displays the time selected and stores the time selected by the user
    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfHour) {
        // Show the time selected by the user
        TextView textView=(TextView)findViewById(R.id.time_picker_label);

        String tempHour = "";
        String tempMin = "";
        String flag = "";

        if(hourOfDay == 12) {
            tempHour = Integer.toString(hourOfDay);
            flag = " PM";
        }
        else if(hourOfDay >= 12) {
            tempHour = Integer.toString(hourOfDay - 12);
            flag = " PM";
        }
        else{
            if(hourOfDay == 0)
                tempHour = Integer.toString(12);
            else
                tempHour = Integer.toString(hourOfDay);
            flag = " AM";
        }

        if(minuteOfHour == 0)
            tempMin = "00";
        else if(Integer.toString(minuteOfHour).length() == 1)
            tempMin = "0"+ minuteOfHour;
        else
            tempMin = Integer.toString(minuteOfHour);

        System.out.println(hourOfDay+" "+minuteOfHour);
        textView.setText(tempHour+":"+tempMin+flag);

        // Store the time selected by the user
        hour = hourOfDay;
        minute = minuteOfHour;
    }

    // Delegate function that recognises the tap on back button of this Activity
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // This function creates a new Habit
    public Habit createHabit(String hName, RadioButton hType, String hMsg, int hTime, int mTime) {
        // A boolean variable that is true for Good_Habit and false for Bad_Habit
        boolean boolType;
        if(hType.getId() == findViewById(R.id.good_habit).getId()) {
            boolType = true;
        }
        else {
            boolType = false;
        }
        return new Habit(hName, boolType, hMsg, hTime, mTime);
    }

    // This Function Adds a new Habit to the list of Habits
    public void addHabit(Habit habit)
    {
        HabitStorage.addToHabitStorage(habit);
    }

    public void checkToaster()
    {
        // Check if the user selected a time
        if(hour == -1 && minute == -1)
        {
            Toast.makeText(this,"You have to select a time",Toast.LENGTH_SHORT).show();
            toastFired = true;
        }
        // Check if the user selected a type of Habit
        if(typeGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"You have select a type of Habit",Toast.LENGTH_SHORT).show();
            toastFired = true;
        }
        // Check if the user gave a Habit a name
        if(name == null || name.length() < 1)
        {
            Toast.makeText(this,"You have to assign a name to your Habit",Toast.LENGTH_SHORT).show();
            toastFired = true;
        }
    }
}
