package com.example.goodhabit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import comp3350.goodhabits.Application.App;
import comp3350.goodhabits.Logic.HabitManager;
import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Persistence.SQLite.HabitSQLite;
import comp3350.goodhabits.Presentation.MainActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HabitSqlIT {
    HabitSQLite dbHelper;

    @Before
    public void setUp(){
        MainActivity activity = new MainActivity();
        activity.setContext();
        new HabitManager(new HabitSQLite(App.getContext()));
        dbHelper = Mockito.mock(HabitSQLite.class);
    }

    @Test
    public void checkAdd() {
        Habit habit = new Habit(121, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        Mockito.when(dbHelper.addHabit(habit)).thenReturn(true);
        assertTrue(dbHelper.addHabit(habit));
    }

    @Test
    public void checkDelete(){
        Habit habit = new Habit(122, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        dbHelper.addHabit(habit);
        Mockito.when(dbHelper.deleteHabit(habit)).thenReturn(true);
        assertTrue(dbHelper.deleteHabit(habit));
    }

    @Test
    public void checkHabitListSize(){
        Habit habit = new Habit(123, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        dbHelper.addHabit(habit);
        Mockito.when(dbHelper.getHabitListSize()).thenReturn(1);
        assertEquals(dbHelper.getHabitListSize(), 1);
    }

    @Test
    public void checkDeleteHabitByIndex(){
        Habit habit = new Habit(124, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        dbHelper.addHabit(habit);
        habit = new Habit(125, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        dbHelper.addHabit(habit);
        Mockito.when(dbHelper.deleteHabitByIndex(1)).thenReturn(true);
        assertTrue(dbHelper.deleteHabitByIndex(1));
    }

    @Test
    public  void checkMakeListEmpty(){
        Habit habit = new Habit(126, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        dbHelper.addHabit(habit);
        habit = new Habit(127, "Code early in the morning", true, "Coding early morning increases productivity.", 6, 30, "01/03/2021", "05/05/2021", 10);
        dbHelper.addHabit(habit);
        Mockito.when(dbHelper.getHabitListSize()).thenReturn(2);
        assertEquals(dbHelper.getHabitListSize(), 2);
        dbHelper.makeListEmpty();
        Mockito.when(dbHelper.getHabitListSize()).thenReturn(0);
        assertEquals(dbHelper.getHabitListSize(), 0);
    }

}
