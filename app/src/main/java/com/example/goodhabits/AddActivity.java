package com.example.goodhabits;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    //Fields
    private String name;
    private RadioGroup Habit_type;
    private RadioButton type_button;
    private String msg;
    private int hour=-1;//Initialized to -1
    private int minute=-1;//Initialized to -1
    private boolean ToastFired=false;//Used to check if any toast messages were given
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Contexts of the form that need to be stored
        EditText Habit_Name;
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
        //Get the name of the Habit when it is Written
        Habit_Name=findViewById(R.id.habit_name);

        //Tapping a RadioButton to determine type of Habit
        Habit_type=findViewById(R.id.radiogroup);
        Habit_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                //Assign the new selected button to type_button
                type_button=findViewById(id);
            }
        });


        //When the User message is written
        User_Msg=findViewById(R.id.habit_msg);

        //Tapping the Time Picker Button to select a time for the activity regarding the habit
        time_Btn=findViewById(R.id.time_picker);
        time_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker=new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });

        //Tapping the "Submit" Button on the addHabit form
        Submit_Btn=findViewById(R.id.submit_button);
        Submit_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This boolean value is used to check if any toast messages are given
                ToastFired=false;
                //Get the name of the habit
                name=Habit_Name.getText().toString();

                //Get the HabitType selected (If the user does not click on the RadioButtons)
                int radioId=Habit_type.getCheckedRadioButtonId();
                type_button=findViewById(radioId);

                //Get the User message
                msg=User_Msg.getText().toString();

                //Check for toast message
                checkToaster();

                //If any Toast message is NOT displayed
                if(ToastFired==false) {
                    //Create a Habit
                    Habit newHabit=createHabit(name,type_button,msg,hour,minute);
                    //Add the Habit to the list of Habits
                    //addHabit(newHabit);
                    //Go to the main screen
                    startActivity(new Intent(AddActivity.this, MainActivity.class));
                }
            }
        });
    }

    //This Function finds the RadioButton that is selected by the user
    public void selectedButton(View v)
    {
        //Get the ID of the selected button
        int radioId= Habit_type.getCheckedRadioButtonId();
        //Assign it to our RadioButton Variable
        type_button=findViewById(radioId);

    }

    //This Function displays the time selected and stores the time selected by the user
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfHour) {
        //Show the time selected by the user
        TextView textView=(TextView)findViewById(R.id.textView7);
        textView.setText("Hour: "+hourOfDay+" Minute: "+minuteOfHour);
        //Store the time selected by the user
        hour=hourOfDay;
        minute=minuteOfHour;
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
    public Habit createHabit(String hName, RadioButton hType, String hMsg, int hTime, int mTime) {
        //A boolean variable that is true for Good_Habit and false for Bad_Habit
        boolean boolType;
        if (hType.getId() == findViewById(R.id.Good_Habit).getId()) {
            boolType = true;
        } else
        {
            boolType=false;
        }
        return new Habit(hName,boolType,hMsg,hTime,mTime);
    }

    //This Function Adds a new Habit to the list of Habits
//    public void addHabit(Habit h)
//    {
//
//    }

    public void checkToaster()
    {
        //Check if the user selected a time
        if(hour==-1 && minute==-1)
        {
            Toast.makeText(this,"You have to select a time",Toast.LENGTH_SHORT).show();
            ToastFired=true;
        }
        //Check if the user selected a type of Habit
        if(Habit_type.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(this,"You have select a type of Habit",Toast.LENGTH_SHORT).show();
            ToastFired=true;
        }
        //Check if the user gave a Habit a name
        if(name==null || name.length()<1)
        {
            Toast.makeText(this,"You have to assign a name to your Habit",Toast.LENGTH_SHORT).show();
            ToastFired=true;
        }

    }
}

