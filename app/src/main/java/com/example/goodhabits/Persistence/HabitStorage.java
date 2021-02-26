package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Habit;

import java.util.ArrayList;

// This Class acts as a Storage for all the Habits created
public class HabitStorage implements HabitStorageManager{
    // Non-persistence ArrayList to store all the Habit objects
    private static final ArrayList<Habit> habitStorage = new ArrayList<>();

    public HabitStorage(){

    }

    // Function to add a Habit to the ArrayList
    public void addToHabitStorage(Habit habit){
        habitStorage.add(habit);
    }

    // Function to get the full list of Habits
    public ArrayList<Habit> getHabitStorage(){
        return habitStorage;
    }

    // Function to get the names of each Habit in the ArrayList, in the form of a String array
    public String[] getAllName() throws Exception{
        if(habitStorage.size() == 0)
            throw new Exception("ERROR: HabitStorage is empty");
        String[] result = new String[habitStorage.size()];
        for(int i=0; i<habitStorage.size(); i++){
            result[i] = habitStorage.get(i).getHabitName();
        }
        return result;
    }

    // Function to get the size of the ArrayList that has all the Habits
    public int getHabitStorageSize(){
        return habitStorage.size();
    }

}
