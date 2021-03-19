package comp3350.goodhabits.Logic;

import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Persistence.HabitStorageI;

import java.util.ArrayList;

public class HabitManager {

    private static HabitStorageI habitStorage;

    public HabitManager(HabitStorageI db){
        habitStorage = db;
    }

    public static ArrayList<Habit> getHabitList(){
        return habitStorage.getHabitList();
    }

    public static boolean addHabit(Habit habit){
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

    public static boolean deleteHabit(Habit habit){
        return habitStorage.deleteHabit(habit);
    }

    public static int getHabitListSize(){
        return habitStorage.getHabitList().size();
    }

    public static void makeListEmpty(){
        habitStorage.makeListEmpty();
    }

    public static void deleteHabitByIndex(int index){
        habitStorage.deleteHabitByIndex(index);
    }

    public static int getID(){
        int id = 0;
        if(habitStorage.getHabitList().size() == 0){
            id = 1;
        }
        else{
            ArrayList<Habit> list = habitStorage.getHabitList();
            Habit habit = list.get(list.size()-1);
            id = habit.getId()+1;
        }
        return id;
    }
}
