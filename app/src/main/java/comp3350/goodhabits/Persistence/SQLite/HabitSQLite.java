package comp3350.goodhabits.Persistence.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Persistence.HabitStorageI;

import java.util.ArrayList;


public class HabitSQLite extends SQLiteOpenHelper implements HabitStorageI {

    private ArrayList<Habit> habitList = null;

    public HabitSQLite(Context context) {
        super(context, "Habits.db", null, 1);
        habitList = new ArrayList<>();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Habits(id INTEGER primary key, name TEXT, type INTEGER, msg TEXT, hour INTEGER, minute INTEGER, startDate TEXT, endDate TEXT, daysCheckedIn INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Habits");
        onCreate(db);
    }

    public ArrayList<Habit> getHabitList(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from Habits", null);
        habitList.clear();
        int i = 0;
        while(cr.moveToNext()){
            boolean type = cr.getInt(2) == 1;
            Habit habit = new Habit(cr.getInt(0),cr.getString(1), type, cr.getString(3), cr.getInt(4), cr.getInt(5), cr.getString(6), cr.getString(7), cr.getInt(8));
            habitList.add(i++, habit);
        }
        cr.close();
        db.close();
        return habitList;
    }

    public boolean addHabit(Habit habit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", habit.getId());
        cv.put("name", habit.getHabitName());
        int type = habit.getHabitType() ? 1: 0;
        cv.put("type", type);
        cv.put("msg", habit.getHabitMsg());
        cv.put("hour", habit.getHour());
        cv.put("minute", habit.getMinute());
        cv.put("startDate", habit.getStartDate());
        cv.put("endDate", habit.getEndDate());
        cv.put("daysCheckedIn", habit.getDaysCheckedIn());
        long num = db.insert("Habits", null, cv);
        habitList.add(habit);
        db.close();
        return num != -1;
    }

    public boolean deleteHabit(Habit habit){
        boolean result = false;
        int id = habit.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from Habits where id = ?", new String[]{String.valueOf(id)});
        if(cr.getCount() > 0){
            long num = db.delete("Habits", "id=?", new String[]{String.valueOf(id)});
            result = num != -1;
            if(result){
                habitList.remove(habit);
            }
        }
        cr.close();
        db.close();
        return result;
    }

    public int getHabitListSize(){
        return habitList.size();
    }

    public void makeListEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Habits");
        habitList.clear();
        db.close();
    }

    public boolean deleteHabitByIndex(int index){
        boolean result = false;
        Habit habit = habitList.remove(index);
        if(habit != null){
            deleteHabit(habit);
            result = true;
        }
        return result;
    }
}