package com.example.friendfinderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        // init
        TextView detail_event_name = findViewById(R.id.detail_event_name);
        ImageView detail_event_image = findViewById(R.id.detail_event_image);
        ImageView btn_back_to_see_all = findViewById(R.id.btn_back_to_see_all);
        TextView detail_event_date = findViewById(R.id.detail_event_date);

        // get parsing data
        if (getIntent() != null) {
            String event_name = getIntent().getStringExtra("event_name").toString();
            int event_image = getIntent().getIntExtra("event_image", 0);
            String event_date = getIntent().getStringExtra("event_date").toString();
            detail_event_name.setText(event_name);
            detail_event_image.setImageResource(event_image);
            detail_event_date.setText(event_date);
        }
        ;

        btn_back_to_see_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeSeeAll();
            }
        });
    }

    private void openHomeSeeAll() {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        finish();
    }
}