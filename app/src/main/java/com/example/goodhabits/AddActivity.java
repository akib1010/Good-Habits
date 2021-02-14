package com.example.goodhabits;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    //Fields
    private String name;
    private boolean type;
    private String msg;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Contexts of the form that need to be stored
        EditText Habit_Name;
        Switch Habit_Type;
        EditText User_Msg;
        Button time_Btn;
        Button Submit_Btn;

        // Title Bar text
        setTitle("Add a Habit");

        // Tapping the back button takes you to Home Screen
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //Initializing the fields
        //When the name of the Habit is Written
        Habit_Name=findViewById(R.id.habit_name);

        //When the type of Habit is selected
        Habit_Type=findViewById(R.id.habit_switch);

        //When the User message is written
        User_Msg=findViewById(R.id.habit_msg);

        //Tapping the Time Picker Button to select a time for the activity regarding the habit
        time_Btn=(Button)findViewById(R.id.time_picker);
        time_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker=new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });

        //Tapping the "Submit" Button on the create form
        Submit_Btn=findViewById(R.id.submit_button);
        Submit_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the name of the habit
                name=Habit_Name.getText().toString();
                assert name.length()>0 : "You have to give a name to your Habit";
                //Get the type of the habit
                type=Habit_Type.isChecked();
                assert type==true || type==false : "Type of habit is not selected?";
                //Get the User message
                msg=User_Msg.getText().toString();
                //The User message can be empty if the user decides to
                if(msg.length()==0)
                {
                    msg="";
                }
                //Create a Habit
                Habit newHabit=createHabit(name,type,msg,hour,minute);
                //Add the Habit to the list of Habits
                //addHabit(newHabit);
                //Go to Home Screen
                startActivity(new Intent(AddActivity.this,MainActivity.class));
            }
        });
    }
    //This Function displays the time selected and stores the time selected by the user
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfHour) {
        //Show the time selected by the user
        TextView textView=(TextView)findViewById(R.id.textView7);
        textView.setText("Hour: "+hourOfDay+" Minute: "+minuteOfHour);
        //Store the time selected by the user
        hour=hourOfDay;
        assert hour>0 && hour<25 : "Invalid Time";
        minute=minuteOfHour;
        assert minute>=0 && minute<60 : "Invalid Time";
    }



    // Delegate function that recognises the tap on back button of this Activity
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //This function creates a new Habit
    public Habit createHabit(String hName, boolean hType, String hMsg, int hTime, int mTime)
    {
        return new Habit(hName,hType,hMsg,hTime,mTime);
    }

    //This Function Adds a new Habit to the list of Habits
//    public void addHabit(Habit h)
//    {
//
//    }




}

