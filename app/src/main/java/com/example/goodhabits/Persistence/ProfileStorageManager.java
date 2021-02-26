package com.example.goodhabits.Persistence;

import com.example.goodhabits.Objects.Profile;

import java.util.ArrayList;

public interface ProfileStorageManager {
    public void addToProfileStorage(Profile profile);
    public Profile getProfileStorage();
}
