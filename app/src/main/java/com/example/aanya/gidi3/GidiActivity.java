package com.example.aanya.gidi3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GidiActivity extends AppCompatActivity implements View.OnClickListener {
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidi);

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(GidiActivity.this,Profile.class);
        startActivity(intent);
    }
}
