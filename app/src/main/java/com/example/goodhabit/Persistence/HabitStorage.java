package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Habit;

import java.util.ArrayList;

// This Class acts as a Storage for all the Habits created
public class HabitStorage{
    // Non-persistence ArrayList to store all the Habit objects
    private static final ArrayList<Habit> habitStorage = new ArrayList<>();

    public HabitStorage(){

    }

    // Function to add a Habit to the ArrayList
    public void addHabit(Habit habit){
        habitStorage.add(habit);
    }

    // Function to get the full list of Habits
    public ArrayList<Habit> getHabitList(){
        return habitStorage;
    }

    // Function to get the names of each Habit in the ArrayList, in the form of a String array
    public String[] getAllHabitNames() throws Exception{
        if(habitStorage.size() == 0)
            throw new Exception("ERROR: HabitStorage is empty");
        String[] result = new String[habitStorage.size()];
        for(int i=0; i<habitStorage.size(); i++){
            result[i] = habitStorage.get(i).getHabitName();
        }
        return result;
    }

    public void deleteHabit(int index) {
        habitStorage.remove(index);
    }

    // Function to get the size of the ArrayList that has all the Habits
    public int getHabitListSize(){
        return habitStorage.size();
    }

}
