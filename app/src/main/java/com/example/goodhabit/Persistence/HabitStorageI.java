package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Habit;

import java.util.ArrayList;

public interface HabitStorageI {
    ArrayList<Habit> getHabitList();
    boolean addHabit(Habit habit);
    String[] getAllHabitNames() throws Exception;
    void deleteHabit(int index);
    int getHabitListSize();
}
