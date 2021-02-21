package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Profile;

import java.util.ArrayList;

public class ProfileStorage {
    private static ArrayList<Profile> profileStorge;

    public ProfileStorage(){
        profileStorge = new ArrayList<>();
    }

    public void addToProfileStorage(Profile profile){
        profileStorge.add(profile);
    }

    public static ArrayList<Profile> getProfileStorage(){
        return profileStorge;
    }

    public static int getStorageSize(){
        return profileStorge.size();
    }
}
