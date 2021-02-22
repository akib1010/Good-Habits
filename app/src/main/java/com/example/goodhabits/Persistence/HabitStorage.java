package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Habit;

import java.util.ArrayList;

public class HabitStorage {
    private static ArrayList<Habit> habitStorage = new ArrayList<>();

    public HabitStorage(){
    }

    public static void addToHabitStorage(Habit habit){
        habitStorage.add(habit);
    }

    public static ArrayList<Habit> getHabitStorage(){
        return habitStorage;
    }
    public static String[] getAllName(){
        String[] result = new String[habitStorage.size()];
        for(int i=0; i<habitStorage.size(); i++){
            result[i] = habitStorage.get(i).getHabitName();
        }
        return result;
    }


    public static int getStorageSize(){
        return habitStorage.size();
    }
}
