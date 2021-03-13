package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Profile;

import java.util.ArrayList;

public interface ProfileStorageInterface {
    void addToProfileStorage(Profile profile);
    Profile getProfileStorage();
}
