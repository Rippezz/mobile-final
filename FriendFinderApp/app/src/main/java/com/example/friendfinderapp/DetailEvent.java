package com.example.friendfinderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.friendfinderapp.Constants.ConfigurationAll;

public class DetailEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        // init
        ImageView btn_back_to_see_all = findViewById(R.id.btn_back_to_see_all);
        TextView detail_event_name = findViewById(R.id.detail_event_name);
        ImageView detail_event_image = findViewById(R.id.detail_event_image);
        TextView detail_event_date = findViewById(R.id.detail_event_date);
        TextView detail_contact_person = findViewById(R.id.detail_contact_person);
        TextView detail_owner_name = findViewById(R.id.detail_owner_name);
        TextView detail_description = findViewById(R.id.detail_description);

        // get parsing data
        if (getIntent() != null) {

            String event_name = getIntent().getStringExtra("event_name");
            String event_picture = getIntent().getStringExtra("event_picture");
            String start_date = getIntent().getStringExtra("start_date");
            String event_owner = getIntent().getStringExtra("event_owner");
            String contact_person = getIntent().getStringExtra("contact_person");
            String description = getIntent().getStringExtra("description");

            detail_event_name.setText(event_name);
            detail_event_date.setText(start_date);
            detail_contact_person.setText(contact_person);
            detail_owner_name.setText(event_owner);
            detail_description.setText(description);

            Glide.with(this).load(ConfigurationAll.ImageURL + event_picture).into(detail_event_image);

        };
        btn_back_to_see_all.setOnClickListener(new View.OnClickListener() {
            @MainThread
            public void onBackPressed() {
                getOnBackPressedDispatcher().onBackPressed();
            }

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}