package com.example.friendfinderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.friendfinderapp.Constants.ConfigurationAll;

public class DetailPlace extends AppCompatActivity {

    // init
    private TextView txt_place_name, txt_description, txt_place_owner, txt_place_price,
            txt_place_open, txt_location, txt_contact_person;
    private ImageView iv_place_picture, back_to_see_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        txt_place_name = findViewById(R.id.detail_place_name);
        txt_description = findViewById(R.id.detail_place_description);
        txt_place_owner = findViewById(R.id.detail_place_owner);
        txt_place_price = findViewById(R.id.detail_place_price);
        txt_place_open = findViewById(R.id.detail_place_schedule);
        txt_location = findViewById(R.id.detail_place_location);
        txt_contact_person = findViewById(R.id.detail_place_contact_person);
        iv_place_picture = findViewById(R.id.detail_place_image);
        back_to_see_all = findViewById(R.id.btn_back_to_see_all);

        back_to_see_all.setOnClickListener(new View.OnClickListener() {
            public void onBackPressed() {
                getOnBackPressedDispatcher().onBackPressed();
            }

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (getIntent() != null) {
            String place_name = getIntent().getStringExtra("place_name");
            String place_picture = getIntent().getStringExtra("place_picture");
            String description = getIntent().getStringExtra("description");
            String place_owner = getIntent().getStringExtra("place_owner");
            String place_price = getIntent().getStringExtra("place_price");
            String place_time_schedule = getIntent().getStringExtra("place_time_schedule");
            String location = getIntent().getStringExtra("location");
            String contact_person = getIntent().getStringExtra("contact_person");

            txt_place_name.setText(place_name);
            txt_description.setText(description);
            txt_place_owner.setText(place_owner);
            txt_place_price.setText(place_price);
            txt_place_open.setText(place_time_schedule);
            txt_location.setText(location);
            txt_contact_person.setText(contact_person);

            Glide.with(getApplicationContext()).load(ConfigurationAll.ImageURL + place_picture).into(iv_place_picture);
        }
    }
}