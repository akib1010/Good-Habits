package com.example.goodhabit.Application;

import com.example.goodhabit.Persistence.HabitHSQLDB;
import com.example.goodhabit.Persistence.HabitStorageI;

public class Services {
    private static HabitStorageI habitStorage = null;

    public static synchronized HabitStorageI getHabitStorage(){
        if(habitStorage == null){
            habitStorage = new HabitHSQLDB(Main.getDBPathName());
        }
        return habitStorage;
    }
}
