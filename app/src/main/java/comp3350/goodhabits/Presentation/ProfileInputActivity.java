package comp3350.goodhabits.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import comp3350.goodhabits.Logic.ProfileManager;
import comp3350.goodhabits.Objects.Profile;
import comp3350.goodhabits.Persistence.SQLite.ProfileSQLite;
import comp3350.goodhabits.R;


public class ProfileInputActivity extends AppCompatActivity {

    private EditText profileName;
    private EditText profileEmail;

    @Override
    protected void onResume() {
        super.onResume();

        // Manager for Persistent Profile Storage
        new ProfileManager(new ProfileSQLite(this));

        // Manager for Non-Persistent Profile Storage
        // new ProfileManager(new ProfileStorage());

        // If profileIsSet is true then fills profile with fake data and goes directly to Main Screen
        if(ProfileManager.getProfileStorage() != null){
            moveToMainActivity();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);

        // Title Bar text for this Activity
        setTitle("Create a Profile");

        // Extracting the profileName given by the user
        profileName = (EditText)findViewById(R.id.name_input);

        // Extracting the profileEmail given by the user
        profileEmail = (EditText)findViewById(R.id.email_input);

        // Button that validates Profile info, after being clicked
        Button done = (Button) findViewById(R.id.submit_profile);
        done.setOnClickListener(v -> validateForm());
    }

    // Helper function to move to Main Activity
    public void moveToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Function to validate the Profile form
    public void validateForm(){
        boolean pass = true;

        String name = profileName.getText().toString();
        String email = profileEmail.getText().toString();

        // Fire a toast message if name field is empty
        if(name.equals("")){
            Toast.makeText(this, "Name is missing!", Toast.LENGTH_SHORT).show();
            pass = false;
        }
        // Fire a toast message if email field is empty
        if(email.equals("") && pass){
            Toast.makeText(this, "Email is missing!", Toast.LENGTH_SHORT).show();
            pass = false;
        }
        // If all fields are filled, then store the Profile and go to Main Screen
        if(pass){
            Profile profile = new Profile(name, email);
            ProfileManager.addToProfileStorage(profile);
            moveToMainActivity();
        }
    }
}
