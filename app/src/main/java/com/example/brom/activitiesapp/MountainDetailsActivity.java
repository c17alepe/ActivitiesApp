package com.example.brom.activitiesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets the new view to the activity_mountaindetails layout
        setContentView(R.layout.activity_mountaindetails);

        //gets the input from previous screen and outputs into textview in the card
        Intent intent = getIntent();
        String textinfo = intent.getStringExtra("berg");

        TextView textView = findViewById(R.id.textView);
        textView.setText(textinfo);


    }

}
