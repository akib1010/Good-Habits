package com.example.goodhabit.Logic;

import com.example.goodhabit.Objects.Habit;
import com.example.goodhabit.Persistence.HabitStorageI;

import java.util.ArrayList;

public class HabitManager {

    private static HabitStorageI habitStorage;

    public HabitManager(HabitStorageI db){
        habitStorage = db;
    }

    public static ArrayList<Habit> getHabitList(){
        return habitStorage.getHabitList();
    }

    public static boolean addToHabit(Habit habit){
        return habitStorage.addHabit(habit);
    }

    public static String[] getAllHabitNames() throws Exception{
        ArrayList<Habit> habitList = habitStorage.getHabitList();
        if(habitList.size() == 0)
            throw new Exception("ERROR: HabitStorage is empty");
        String[] result = new String[habitList.size()];
        for(int i=0; i<habitList.size(); i++){
            result[i] = habitList.get(i).getHabitName();
        }
        return result;
    }

    public static void deleteHabit(int index){
        habitStorage.deleteHabit(index);
    }

    public static int getHabitListSize(){
        return habitStorage.getHabitList().size();
    }
}
