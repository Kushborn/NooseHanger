package com.example.noosehanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VinderAktivitet extends AppCompatActivity {

    Button gåtilbage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinder_aktivitet);

        gåtilbage = findViewById(R.id.gåtilbagevinder);

        gåtilbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VinderAktivitet.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
