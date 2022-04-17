package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> myArrayList;
    ListView timesTableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTableListView = (ListView) findViewById(R.id.timesTableListView);
        TextView myResult = (TextView) findViewById(R.id.textView2);
        timesTableSeekBar.setProgress(1);
        timesTableSeekBar.setMax(100);


        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                /*Log.i("info", Integer.toString(i));*/
                myResult.setText(Integer.toString(i));
                myArrayList = new ArrayList<String>();
                for (int j = 0; j <= 100; j++) {
                    int result = i * j;
                    String message = Integer.toString(i) + " * " + Integer.toString(j) + " = " + Integer.toString(result);
                    myArrayList.add(message);
                    ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, myArrayList);
                    timesTableListView.setAdapter(myAdapter);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


};