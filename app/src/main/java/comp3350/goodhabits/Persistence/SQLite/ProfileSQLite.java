package comp3350.goodhabits.Persistence.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import comp3350.goodhabits.Objects.Profile;
import comp3350.goodhabits.Persistence.ProfileStorageI;


public class ProfileSQLite extends SQLiteOpenHelper implements ProfileStorageI {

    private Profile profile = null;;

    public ProfileSQLite(Context context) {
        super(context, "Profile.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Profile(name TEXT, email TEXT primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Profile");
        onCreate(db);
    }

    public void addToProfileStorage(Profile profile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", profile.getName());
        cv.put("email", profile.getEmail());
        long num = db.insert("Profile", null, cv);
        db.close();
    }

    public Profile getProfileStorage(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select * from Profile", null);
        while(cr.moveToNext()){
            String name = cr.getString(0);
            String email = cr.getString(1);
            profile = new Profile(name, email);
        }
        cr.close();
        db.close();
        return profile;
    }
}