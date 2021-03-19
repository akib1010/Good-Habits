package com.example.goodhabit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.sql.Time;

import comp3350.goodhabits.Logic.ProfileManager;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DateTest.class,
        HabitManagerTest.class,
        HabitSqlIT.class,
        HabitTest.class,
        ProfileManagerTest.class,
        ProfileTest.class,
        TimeTest.class
})
public class AllUnitTest {

}
