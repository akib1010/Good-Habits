package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Habit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabitHSQLDB implements HabitStorageInterface {

    private ArrayList<Habit> habitList;
    private String path;

    public HabitHSQLDB(String db){
        habitList = new ArrayList<>();
        path = db;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + path + ";shutdown=true", "SA", "");
    }

//    private Habit fromResultSet(final ResultSet rs) throws SQLException {
//        return new Habit(null);
//    }

    @Override
    public ArrayList<Habit> getHabitList(){
        return new ArrayList<>(null);
    }

    @Override
    public void addToHabitStorage(Habit habit){

    }

    @Override
    public String[] getAllHabitNames() throws Exception{
        return new String[]{"xxx", "hguigh"};
    }

    @Override
    public int getHabitStorageSize(){
        return 0;
    }
}
