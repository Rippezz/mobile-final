package com.example.friendfinderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

public class EventForm extends AppCompatActivity {
    private Spinner spinner;
    private String[] list_category = {"Sport", "Education", "Game"};
    private Button btnTambahData;
    private String eventname,owner,cp,desc;
    private EditText edeventname,edeventowner,edeventcp,edeventdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_form);
        spinner = findViewById(R.id.cb_category);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list_category);
        spinner.setAdapter(arrayAdapter);
        btnTambahData = findViewById(R.id.tambahdata);
        edeventname = findViewById(R.id.et_event_name);
        edeventowner = findViewById(R.id.et_event_owner);
        edeventcp = findViewById(R.id.et_contact_person);
        edeventdesc = findViewById(R.id.et_description);

        btnTambahData.setOnClickListener(v -> {
                    eventname = edeventname.getText().toString();
                    owner = edeventowner.getText().toString();
                    cp = edeventcp.getText().toString();
                    desc = edeventdesc.getText().toString();
                    spinner = spinner.get
                });

        ImageView btn_back_to_user_event = findViewById(R.id.btn_back_to_user_event);

        btn_back_to_user_event.setOnClickListener(new View.OnClickListener() {
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