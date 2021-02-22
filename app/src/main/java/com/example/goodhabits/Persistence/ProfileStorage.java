package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Profile;

import java.util.ArrayList;

// This Class acts as a storage for the User's profile information
public class ProfileStorage implements ProfileStorageManager {
    // Non-persistence ArrayList to store the Habit object
    private static final ArrayList<Profile> profileStorage = new ArrayList<>();;

    public ProfileStorage(){

    }

    // Function to add the User's profile to an ArrayList
    public void addToProfileStorage(Profile profile){
        profileStorage.add(profile);
    }

    // Function to get the User's profile in the ArrayList
    public ArrayList<Profile> getProfileStorage(){
        return profileStorage;
    }

    // Function to get the size of the ArrayList containing the profile
    public int getStorageSize(){
        return profileStorage.size();
    }
}
