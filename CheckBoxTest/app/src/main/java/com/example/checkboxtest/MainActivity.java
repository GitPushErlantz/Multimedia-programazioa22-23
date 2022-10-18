package com.example.checkboxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox cbAlain = findViewById(R.id.cbAlain);
        CheckBox cbIker = findViewById(R.id.cbIker);
        CheckBox cbKarmele = findViewById(R.id.cbKarmele);
        CheckBox cbErlantz = findViewById(R.id.cbErlantz);
        Button btnCheckBox = findViewById(R.id.btnCheckBox);
        Spinner spnAukerak = findViewById(R.id.spnAukerak);
        Button btnSpinner = findViewById(R.id.btnSpinner);
        String[] arraySpinner = new String[] {
                "Java", "C#", "Android", "Odoo", "C"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, arraySpinner);
        spnAukerak.setAdapter(adapter);
        btnSpinner.setOnClickListener(view -> {
            String msg = spnAukerak.getSelectedItem().toString();
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
        btnCheckBox.setOnClickListener(view -> {
            String msg = "";
            int i = 0;
            if (cbAlain.isChecked()) {
                msg += "Alain ";
                ++i;
            }
            if (cbIker.isChecked()) {
                msg += "Iker ";
                ++i;
            }
            if (cbKarmele.isChecked()) {
                msg += "Karmele ";
                ++i;
            }
            if (cbErlantz.isChecked()) {
                msg += "Erlantz ";
                ++i;
            }
            if (i == 0) {
                Toast.makeText(MainActivity.this, "Ez da inor aukeratu", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}