package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Profile;

// This Class acts as a storage for the User's profile information
public class ProfileStorage implements ProfileStorageInterface {
    // Non-persistence ArrayList to store the Habit object
    private static Profile userProfile = null;

    public ProfileStorage(){

    }

    // Function to add the User's profile to an ArrayList
    public void addToProfileStorage(Profile profile){
        userProfile = profile;
    }

    // Function to get the User's profile in the ArrayList
    public Profile getProfileStorage(){
        return userProfile;
    }
}
