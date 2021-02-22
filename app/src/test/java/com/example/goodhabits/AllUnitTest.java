package com.example.goodhabits;

import com.example.goodhabits.Logic.TimeParser;
import com.example.goodhabits.Objects.Habit;
import com.example.goodhabits.Objects.Profile;
import com.example.goodhabits.Persistence.HabitStorage;
import com.example.goodhabits.Persistence.ProfileStorage;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AllUnitTest {

    @Test
    public void checkTimeIn12Hr() {
        TimeParser time = new TimeParser();
        String result = time.getTime(0, 0);
        assertEquals("12:00 AM", result);
    }

    @Test
    public void checkProfileInStorage() {
        ProfileStorage storage = new ProfileStorage();
        storage.addToProfileStorage(new Profile("John Doe", "johndoe@gmail.com"));
        assertEquals(1, storage.getStorageSize());
    }

    @Test
    public void checkHabitInStorage() {
        HabitStorage.addToHabitStorage(new Habit("Test Habit", true, "This is a Test Habit", 11, 30));
        assertEquals(1, HabitStorage.getStorageSize());
    }

}
