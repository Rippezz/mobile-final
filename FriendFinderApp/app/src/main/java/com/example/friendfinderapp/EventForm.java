package com.example.friendfinderapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class EventForm extends AppCompatActivity {
    private Spinner spinner;
    private String[] list_category = {"Sport", "Education", "Game"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_form);
        spinner = findViewById(R.id.cb_category);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list_category);
        spinner.setAdapter(arrayAdapter);
    }

}