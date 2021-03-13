package com.example.goodhabit.Application;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class Main {
    private static String dbName="SC";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void setDBPathName(final String name) {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            Log.e("Setting up DB driver", e.toString());
            e.printStackTrace();
        }
        dbName = name;
    }

    public static String getDBPathName() {
        return dbName;
    }
}
