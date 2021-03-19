package comp3350.goodhabits.Logic;

import comp3350.goodhabits.Objects.Profile;
import comp3350.goodhabits.Persistence.ProfileStorageI;

public class ProfileManager {

    private static ProfileStorageI profileStorage;

    public ProfileManager(ProfileStorageI db){
        profileStorage = db;
    }

    public static void addToProfileStorage(Profile profile){
        profileStorage.addToProfileStorage(profile);
    }

    public static Profile getProfileStorage(){
        return profileStorage.getProfileStorage();
    }

}
