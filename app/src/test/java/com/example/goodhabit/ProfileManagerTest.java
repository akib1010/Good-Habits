package com.example.goodhabit;
import comp3350.goodhabits.Logic.HabitManager;
import comp3350.goodhabits.Logic.ProfileManager;
import comp3350.goodhabits.Objects.Habit;
import comp3350.goodhabits.Objects.Profile;
import comp3350.goodhabits.Persistence.Stubs.HabitStorage;
import comp3350.goodhabits.Persistence.Stubs.ProfileStorage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfileManagerTest {

    @Before
    public void setup()
    {
        ProfileManager.createDB(new ProfileStorage());
    }

    @Test
    public void TestAddToProfileStorage()
    {
        Profile profile = new Profile("Admin","Admin@myumanitoba.ca");
        ProfileManager.addToProfileStorage(profile);
        assertEquals(ProfileManager.getProfileStorage().getName(), profile.getName());
    }
}
