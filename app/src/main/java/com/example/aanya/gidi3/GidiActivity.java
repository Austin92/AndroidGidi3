package com.example.aanya.gidi3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GidiActivity extends AppCompatActivity  {
    Button btnProfile,btnExercise,btnWorkout,btnNutrition,
            btnStretches,btnChallenges,btnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidi);

        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnExercise = (Button) findViewById(R.id.btnExercise);
        btnWorkout = (Button) findViewById(R.id.btnWorkout);
        btnNutrition = (Button) findViewById(R.id.btnNutrition);
        btnStretches = (Button) findViewById(R.id.btnStretches);
        btnChallenges = (Button) findViewById(R.id.btnChallenges);
        btnMusic = (Button) findViewById(R.id.btnMusic);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Profile.class);
                startActivity(intent);
            }
        });
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Exercises.class);
                startActivity(intent);
            }
        });

        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Workout.class);
                startActivity(intent);
            }
        });

        btnNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Nutrition.class);
                startActivity(intent);
            }
        });
        btnStretches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Stretches.class);
                startActivity(intent);
            }
        });

        btnChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Challenges.class);
                startActivity(intent);
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GidiActivity.this,Music.class);
                startActivity(intent);
            }
        });
    }

}
