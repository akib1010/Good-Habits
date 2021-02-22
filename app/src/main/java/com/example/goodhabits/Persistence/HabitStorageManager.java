package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Habit;

import java.util.ArrayList;

public interface HabitStorageManager {
    public void addToHabitStorage(Habit habit);
    public ArrayList<Habit> getHabitStorage();
    public String[] getAllName() throws Exception;
    public int getStorageSize();
}
