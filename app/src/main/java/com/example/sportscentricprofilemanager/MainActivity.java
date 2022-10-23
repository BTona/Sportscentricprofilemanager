package com.example.sportscentricprofilemanager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps (View view) {

        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package  mapIntent.setPackage("com.google.android.apps.maps");
        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), Profile.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

//Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);

//Figuring out the correct image
        String drawableName;
        switch (data.getIntExtra("imageID", R.id.imageView10)) {
            case R.id.imageView10:
                drawableName = "lionel";
                break;
            case R.id.imageView11:
                drawableName = "cristiano";
                break;
            case R.id.imageView12:
                drawableName = "mpabbe";
                break;
            case R.id.imageView20:
                drawableName = "lew";
                break;
            case R.id.imageView21:
                drawableName = "thibault";
                break;
            case R.id.imageView22:
                drawableName = "dalves";
                break;
            default:
                drawableName = "lionel";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}