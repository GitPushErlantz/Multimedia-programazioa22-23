package com.example.communicateactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class receiveActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        // Deklaratu kodean erabiliko diren elementuak
        TextView txtName = findViewById(R.id.txtName);
        TextView txtSurname = findViewById(R.id.txtSurname);
        TextView txtNbatuketa = findViewById(R.id.txtN1);
        // Jaso aurreko activitytik bidali den intenteko balioak
        String name = getIntent().getStringExtra("keyName"); // KONTUZ, hauek ondo idatzi behar dira, IDEak ez ditu errore gisa hartzen
        String surname = getIntent().getStringExtra("keySurname");
        String nbat = getIntent().getStringExtra("keyNbat");
        String nbi = getIntent().getStringExtra("keyNbi");
        // Jarri balio berri hauek testu gisa
        txtName.setText(name);
        txtSurname.setText(surname);
        int nBatuketa = Integer.parseInt(nbat) + Integer.parseInt(nbi); //zenbakien batuketa egiteko
        txtNbatuketa.setText(Integer.toString(nBatuketa));
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent bueltatu = new Intent(receiveActivity.this, MainActivity.class);
        setResult(RESULT_OK, null);
        finishActivity(1);
    }
}