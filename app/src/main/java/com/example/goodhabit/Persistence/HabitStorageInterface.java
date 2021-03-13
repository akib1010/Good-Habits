package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Habit;

import java.util.ArrayList;

public interface HabitStorageInterface {
    ArrayList<Habit> getHabitList();
    void addToHabitStorage(Habit habit);
    String[] getAllHabitNames() throws Exception;
    int getHabitStorageSize();
}
