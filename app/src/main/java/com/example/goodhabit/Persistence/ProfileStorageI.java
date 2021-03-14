package com.example.goodhabit.Persistence;

import com.example.goodhabit.Objects.Profile;

public interface ProfileStorageI {
    void addToProfileStorage(Profile profile);
    Profile getProfileStorage();
}
