package com.example.goodhabits.Presentation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.goodhabits.Objects.Habit;
import com.example.goodhabits.R;

public class DetailActivity extends AppCompatActivity {

    Habit habit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        if(getIntent().getExtras() != null){
            habit = (Habit)getIntent().getSerializableExtra("Habit");
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
}
