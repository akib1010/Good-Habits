package comp3350.goodhabits.Logic;

import comp3350.goodhabits.Objects.Profile;
import comp3350.goodhabits.Persistence.HabitStorageI;
import comp3350.goodhabits.Persistence.ProfileStorageI;

public class ProfileManager {

    private static ProfileStorageI profileStorage = null;

    public static void createDB(ProfileStorageI db){
        profileStorage = db;
    }

    public static ProfileStorageI getDB(){
        return profileStorage;
    }

    public static void addToProfileStorage(Profile profile){
        profileStorage.addToProfileStorage(profile);
    }

    public static Profile getProfileStorage(){
        return profileStorage.getProfileStorage();
    }

}
