package com.example.noosehanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaberAktivitet extends AppCompatActivity {


    Button gåtilbage, highscoreKnap;


    TextView tabteOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taber_aktivitet);

        tabteOrd = findViewById(R.id.ordIkkeFundet);
        gåtilbage = findViewById(R.id.gåtilbagetaber);
        highscoreKnap = findViewById(R.id.highscoretaber);


        tabteOrd.setText(getIntent().getStringExtra("TABT"));

        gåtilbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaberAktivitet.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
