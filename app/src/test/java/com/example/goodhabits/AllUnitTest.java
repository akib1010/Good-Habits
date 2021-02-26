package com.example.goodhabits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        StorageTest.class,
        TimeTest.class
})
public class AllUnitTest {

}
