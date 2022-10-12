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

    public void showLocation(View view) {
        EditText edt = (EditText) findViewById(R.id.tBoxLocation);
        String loc = edt.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(intent);
    }
}