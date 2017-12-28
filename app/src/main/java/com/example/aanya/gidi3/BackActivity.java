package com.example.aanya.gidi3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BackActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView backlistview;
    String[] backguide = {"Lat Pull-Down","Back Lat Pull-Down","Seated Rows","Machine Rows",
            "Chin-Ups","Bent Rows","Deadlifts"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        backlistview = (ListView) findViewById(R.id.backlistView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,backguide);
        backlistview.setAdapter(adapter);
        backlistview.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView temp = (TextView) view;
        Toast.makeText(this,temp.getText()+""+i,Toast.LENGTH_LONG).show();
    }
}
