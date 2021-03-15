package com.example.goodhabit.Persistence.HSQLDB;

import android.util.Log;

import com.example.goodhabit.Objects.Habit;
import com.example.goodhabit.Persistence.HabitStorageI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabitHSQLDB implements HabitStorageI {

    private ArrayList<Habit> habitList;
    private final String path;

    public HabitHSQLDB(String db){
        habitList = new ArrayList<>();
        path = db;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + path + ";shutdown=true", "SA", "");
    }

    private Habit fromResultSet(final ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        int tp = rs.getInt("TYPE");
        boolean type = tp == 1;
        String msg = rs.getString("MESSAGE");
        int hour = rs.getInt("HR");
        int minute = rs.getInt("MINT");;
        String startDate = rs.getString("STARTDATE");
        String endDate = rs.getString("ENDDATE");
        int daysCheckedIn = rs.getInt("DAYSCHECKEDIN");
        return new Habit(id, name, type, msg, hour, minute, startDate, endDate, daysCheckedIn);
    }

    @Override
    public ArrayList<Habit> getHabitList(){
        if(habitList.size() == 0){
            try(Connection c = connection()){
                PreparedStatement st = c.prepareStatement("SELECT * FROM HABITS");
                ResultSet rs = st.executeQuery();

                while(rs.next()){
                    Habit habit = fromResultSet(rs);
                    habitList.add(habit);
                }

                st.close();
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
                Log.w("Getting Habits", e.toString());
            }
        }
        return habitList;
    }

    @Override
    public boolean addHabit(Habit habit){
        boolean returnValue = false;
        try(Connection c = connection()){
            PreparedStatement st = c.prepareStatement("INSERT INTO HABITS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, habit.getId());
            st.setString(2, habit.getHabitName());
            int type = habit.getHabitType() ? 1:0;
            st.setInt(3, type);
            st.setString(4, habit.getHabitMsg());
            st.setInt(5, habit.getHour());
            st.setInt(6, habit.getMinute());
            st.setString(7, habit.getStartDate());
            st.setString(8, habit.getEndDate());
            st.setInt(9, habit.getDaysCheckedIn());
            st.executeUpdate();

            //update cache
            habitList.add(habit);
            st.close();
            returnValue = true;
        }catch (SQLException e){
            Log.w("Adding Habit", e.toString());
            e.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public void deleteHabit(Habit habit){
        try(Connection c = connection()){
            PreparedStatement st = c.prepareStatement("DELETE FROM HABITS WHERE ID = ?");
            st.setInt(1, habit.getId());
            st.executeUpdate();

            //update cache
            habitList.remove(habit);
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
            Log.w("Deleting habit", e.toString());
        }
    }

}
