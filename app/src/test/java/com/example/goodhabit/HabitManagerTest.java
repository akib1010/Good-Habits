package com.example.goodhabit;

import comp3350.goodhabits.Logic.HabitManager;
import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Objects.Profile;
import comp3350.goodhabits.Persistence.Stubs.HabitStorage;
import comp3350.goodhabits.Persistence.Stubs.ProfileStorage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class HabitManagerTest {

    @Before
    public void setup()
    {
        new HabitManager(new HabitStorage());
        HabitManager.addHabit(new Habit(42,"Write Tests", true, "Testing makes ur program good", 11, 30, "13/03/2020", "18/05/2020", 0));
        HabitManager.addHabit(new Habit(43,"Write More Tests", true, "Testing makes ur program good", 11, 30, "13/03/2020", "18/05/2020", 0));
        HabitManager.addHabit(new Habit(44,"Write Even More Tests", true, "Testing makes ur program good", 11, 30, "13/03/2020", "18/05/2020", 0));
    }


    @Test
    public void testGetHabitList()
    {
        assertTrue(HabitManager.getHabitList().size()>0);
    }

    @Test
    public void testAddHabit()
    {
        Habit habit=new Habit(42,"Write Tests", true, "Testing makes ur program good", 11, 30, "13/03/2020", "18/05/2020", 0);
        assertTrue(HabitManager.addHabit(habit));
    }

    @Test
    public void testGetAllHabitNames()
    {
        try
        {
            String[] temp=HabitManager.getAllHabitNames();
            assertTrue(temp.length>0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void TestDeleteHabit()
    {
        Habit del = new Habit(45,"Delete Habit", false, "This Habit will get deleted", 11, 30, "13/03/2020", "18/05/2020", 0);
        HabitManager.addHabit(del);
        assertTrue(HabitManager.deleteHabit(del));
    }


    @Test
    public void TestMakeListEmpty()
    {
        HabitManager.makeListEmpty();
        assertEquals(0,HabitManager.getHabitListSize());
    }

    @Test
    public void TestDeleteHabitByIndex()
    {
        int temp=HabitManager.getHabitListSize();
        Habit del = new Habit(45,"Delete Habit", false, "This Habit will get deleted", 11, 30, "13/03/2020", "18/05/2020", 0);
        HabitManager.addHabit(del);
        HabitManager.deleteHabitByIndex(0);
        assertEquals(temp,HabitManager.getHabitListSize());
    }

    @Test
    public void TestGetId()
    {
        Habit del = new Habit(45,"Delete Habit", false, "This Habit will get deleted", 11, 30, "13/03/2020", "18/05/2020", 0);
        HabitManager.addHabit(del);
        assertEquals(46,HabitManager.getID());
    }





}
