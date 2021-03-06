package com.example.goodhabits;

import com.example.goodhabits.Objects.Habit;
import com.example.goodhabits.Objects.Profile;
import com.example.goodhabits.Persistence.HabitStorage;
import com.example.goodhabits.Persistence.ProfileStorage;

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
        storage.addToHabitStorage(new Habit("Test Habit", true, "This is a Test Habit", 11, 30));
        assertEquals(1, storage.getHabitStorageSize());
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
