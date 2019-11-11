package com.example.noosehanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VinderAktivitet extends AppCompatActivity {

    Button gåtilbage, highscoreKnap;

    TextView livTilbage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinder_aktivitet);

        gåtilbage = findViewById(R.id.gåtilbagevinder);
        livTilbage = findViewById(R.id.tvLiv);
        highscoreKnap = findViewById(R.id.highscorevinder);

        livTilbage.setText(getIntent().getStringExtra("VANDT"));

        gåtilbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VinderAktivitet.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
