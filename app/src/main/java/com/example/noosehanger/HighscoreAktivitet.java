package com.example.noosehanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

public class HighscoreAktivitet extends AppCompatActivity {

    private static final String TAG = "HighScoreAktivitet";
    private ArrayList<String> mUserNames = new ArrayList<>();
    private ArrayList<String> mScores = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore_aktivitet);

        Log.d(TAG, "InitImageBitMaps: laver bitmaps.");

        initImageBitmaps();

    }

    private void initImageBitmaps() {

        mImageUrls.add(R.drawable.reaper);
        mUserNames.add("Benjamin");
        mScores.add("9000");

        mImageUrls.add(R.drawable.unicorn);
        mUserNames.add("Alexandra");
        mScores.add("8999");


        mImageUrls.add(R.drawable.doge);
        mUserNames.add("Douglas");
        mScores.add("6000");


        mImageUrls.add(R.drawable.bird);
        mUserNames.add("Birte");
        mScores.add("666");

        mImageUrls.add(R.drawable.cat);
        mUserNames.add("Glenn");
        mScores.add("420");

        mImageUrls.add(R.drawable.bear);
        mUserNames.add("Daniel");
        mScores.add("10001");

        mImageUrls.add(R.drawable.ghost);
        mUserNames.add("Kristian");
        mScores.add("4200");

        mImageUrls.add(R.drawable.elephant);
        mUserNames.add("Birte");
        mScores.add("666");

        mImageUrls.add(R.drawable.pikapng);
        mUserNames.add("Simon");
        mScores.add("3333");

        mImageUrls.add(R.drawable.frog);
        mUserNames.add("Birte");
        mScores.add("666");

        mImageUrls.add(R.drawable.mime);
        mUserNames.add("Mr. Mime");
        mScores.add("2200");

        mImageUrls.add(R.drawable.squirtle);
        mUserNames.add("Squirtle");
        mScores.add("5550");

        initRecyclerView();

    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recycler.");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mUserNames, mImageUrls, mScores);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
