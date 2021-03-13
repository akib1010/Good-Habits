package com.example.goodhabit.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.goodhabit.R;


public class AllHabitsActivity extends AppCompatActivity {

    MainActivity activity = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_habits);

        ListView listView = (ListView)findViewById(R.id.listview);
        Intent intent = new Intent(this, DetailActivity.class);

        try {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activity.habitStorage.getAllHabitNames());
            listView.setAdapter(arrayAdapter);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // Show a toast message when a row in the list view is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });

        // Title Bar text for this Activity
        setTitle("All Habits");

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
