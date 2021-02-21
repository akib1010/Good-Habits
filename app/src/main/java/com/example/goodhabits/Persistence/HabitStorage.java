package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Habit;

import java.util.ArrayList;

public class HabitStorage {
    private static ArrayList<Habit> habitStorage;

    public HabitStorage(){
        habitStorage = new ArrayList<>();
    }

    public void addToHabitStorage(Habit habit){
        habitStorage.add(habit);
    }

    public static ArrayList<Habit> getHabitStorage(){
        return habitStorage;
    }

    public static int getStorageSize(){
        return habitStorage.size();
    }
}
