package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Profile;

import java.util.ArrayList;

// This Class acts as a storage for the User's profile information
public class ProfileStorage {
    private static ArrayList<Profile> profileStorage;

    public ProfileStorage(){
        profileStorage = new ArrayList<>();
    }

    // Function to add the User's profile to an ArrayList
    public void addToProfileStorage(Profile profile){
        profileStorage.add(profile);
    }

    // Function to get the User's profile in the ArrayList
    public static ArrayList<Profile> getProfileStorage(){
        return profileStorage;
    }
}
