package com.example.communicateactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Deklaratu kodean erabiliko diren elementuak
        Button btnSend = findViewById(R.id.btnSend); // Elementua deklaratzean R.id.elementuarenIzena erabili
        EditText edtName = findViewById(R.id.edtName);
        EditText edtSurname = findViewById(R.id.edtSurname);
        EditText edtN1 = findViewById(R.id.edtN1);
        EditText edtN2 = findViewById(R.id.edtN2);

        //OnClickListener bat sortu
        //Lambda ere erabili daiteke

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString(); // getText-ek Editable bat bueltatzen du, gogoratu Stringera pasatzea
                String surname = edtSurname.getText().toString();
                String nbat = edtN1.getText().toString();
                String nbi = edtN2.getText().toString();
                //Intent bat deklaratu
                Intent intentSecondActivity = new Intent(MainActivity.this, receiveActivity.class);
                intentSecondActivity.putExtra("keyName", name); // Sortu balio batzuk intentaren barruan, gero deitu egin beharko ditugu
                intentSecondActivity.putExtra("keySurname", surname); // Aurrena izena eta gero balioa idazten da, gure kasuan String-ak
                intentSecondActivity.putExtra("keyNbat", nbat);
                intentSecondActivity.putExtra("keyNbi", nbi);
                //Intent-a abiarazi
                startActivity(intentSecondActivity);
            }
        });
    }
}