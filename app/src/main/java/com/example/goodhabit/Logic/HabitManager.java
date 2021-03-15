package com.example.goodhabit.Logic;

import com.example.goodhabit.Objects.Habit;
import com.example.goodhabit.Persistence.HabitStorageI;

import java.util.ArrayList;

public class HabitManager {

    private HabitStorageI habitStorage;

    public HabitManager(HabitStorageI db){
        habitStorage = db;
    }

    public ArrayList<Habit> getHabitList(){
        return habitStorage.getHabitList();
    }

    public boolean addHabit(Habit habit){
        return habitStorage.addHabit(habit);
    }

    public String[] getAllHabitNames() throws Exception{
        ArrayList<Habit> habitList = habitStorage.getHabitList();
        if(habitList.size() == 0)
            throw new Exception("ERROR: HabitStorage is empty");
        String[] result = new String[habitList.size()];
        for(int i=0; i<habitList.size(); i++){
            result[i] = habitList.get(i).getHabitName();
        }
        return result;
    }

    public void deleteHabit(Habit habit){
        habitStorage.deleteHabit(habit);
    }

    public int getHabitListSize(){
        return habitStorage.getHabitList().size();
    }
}
