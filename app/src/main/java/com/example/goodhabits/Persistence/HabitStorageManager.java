package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Habit;

import java.util.ArrayList;

public interface HabitStorageManager {
    public void addToHabitStorage(Habit habit);
    public ArrayList<Habit> getHabitList();
    public String[] getAllHabitNames() throws Exception;
    public int getHabitStorageSize();
}
