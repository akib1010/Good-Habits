package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Habit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabitHSQLDB implements HabitStorageI {

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
        return null;
    }

    @Override
    public boolean addHabit(Habit habit){
        return true;
    }

    @Override
    public String[] getAllHabitNames() throws Exception{
        return new String[]{"dfvsdfsdf", "dsfsdf"};
    }

    @Override
    public void deleteHabit(int index){

    }

    @Override
    public int getHabitListSize(){
        return 0;
    }
}
