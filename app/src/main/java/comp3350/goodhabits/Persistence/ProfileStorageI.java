package comp3350.goodhabits.Persistence;

import comp3350.goodhabits.Objects.Profile;

public interface ProfileStorageI {
    void addToProfileStorage(Profile profile);
    Profile getProfileStorage();
}
