package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void showWebPage(View view) {
        EditText edt = (EditText) findViewById(R.id.tBoxSite);
        try {
            String url = edt.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Please enter a valid URL", Toast.LENGTH_SHORT).show();
        }
    }

    public void showMapCaller(View view) { //TODO: Fix maps
        EditText edt = (EditText) findViewById(R.id.tBoxLocation);
        try {
            String url = edt.getText().toString();
            showMap(Uri.parse(url));
        } catch (Exception e) {
            Toast.makeText(this, "Please enter a valid place", Toast.LENGTH_SHORT).show();
        }
    }

    public void showMap(Uri geoLocation) { //TODO: Fix no app found
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No maps app found", Toast.LENGTH_SHORT).show();
        }
    }

}