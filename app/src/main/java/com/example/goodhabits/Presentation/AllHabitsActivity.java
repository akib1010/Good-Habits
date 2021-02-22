package com.example.goodhabits.Presentation;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.goodhabits.Objects.Profile;
import com.example.goodhabits.Persistence.HabitStorage;
import com.example.goodhabits.Objects.Habit;


import com.example.goodhabits.Persistence.HabitStorage;
import com.example.goodhabits.Persistence.ProfileStorage;
import com.example.goodhabits.R;

import java.util.ArrayList;


public class AllHabitsActivity extends AppCompatActivity {

    ListView listView;
    boolean test = true;
   // HabitStorage storage = new HabitStorage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_habits);

        listView = (ListView)findViewById(R.id.listview);
        //build new arraylist and add some valve


        if(test) {
            HabitStorage.addToHabitStorage(new Habit("gym", true, "every day", 1, 20));
            HabitStorage.addToHabitStorage(new Habit("school", true, "monday", 1, 40));
            HabitStorage.addToHabitStorage(new Habit("home", true, "go back", 5, 30));
            test = false;
        }
        //shallow copy all habit item from storage to arrlist
        //ArrayList<Habit> arrlist=HabitStorage.getHabitStorage();




        //show name on table
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,HabitStorage.getAllName());
        listView.setAdapter(arrayAdapter);
        //show message when user click box
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
             //   Toast.makeText(AllHabitsActivity.this,HabitStorage.getAllName()+" "+HabitStorage.getAllName().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        /*
        listView = (ListView)findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();

        //add value to arrayList
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("h");
        arrayList.add("i");
        arrayList.add("j");
        arrayList.add("k");
        arrayList.add("l");
        //show name on table
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        //show message when user click box
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(AllHabitsActivity.this,"clicked item"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
           */
        // Title Bar text
        setTitle("All Habits");

        // Tapping the back button takes you to Home Screen
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
