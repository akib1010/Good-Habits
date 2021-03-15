package com.example.goodhabit;

import com.example.goodhabit.Objects.Habit;
import com.example.goodhabit.Objects.Profile;
import com.example.goodhabit.Persistence.HabitStorage;
import com.example.goodhabit.Persistence.ProfileStorage;

import org.junit.Test;

import static org.junit.Assert.*;

public class StorageTest {
    @Test
    public void checkProfileInStorage() {
        ProfileStorage storage = new ProfileStorage();
        storage.addToProfileStorage(new Profile("John Doe", "johndoe@gmail.com"));
        assertEquals("John Doe", storage.getProfileStorage().getName());
    }

    @Test
    public void checkHabitInStorage() {
        HabitStorage storage = new HabitStorage();
        storage.addHabit(new Habit(0,"Test Habit", true, "This is a Test Habit", 11, 30, "05/03/2021", "10/05/2021", 0));
        assertEquals(1, storage.getHabitListSize());
        assertEquals("Test Habit", storage.getHabitList().get(0).getHabitName());
    }

    @Test
    public void checkEmptyStorage() {
        HabitStorage storage = new HabitStorage();
        try {
            storage.getAllHabitNames();
        }
        catch (Exception e){
            assertEquals("java.lang.Exception: ERROR: HabitStorage is empty", e.toString());
        }
    }
}
