package com.example.friendfinderapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.friendfinderapp.API.APIRequestData;
import com.example.friendfinderapp.API.RetroServer;
import com.example.friendfinderapp.Constants.ConfigurationAll;
import com.example.friendfinderapp.Home;
import com.example.friendfinderapp.HomeFragment;
import com.example.friendfinderapp.Model.ResponseModel;
import com.example.friendfinderapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
    private EditText etEmail, etPassword;
    String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etEmail = findViewById(R.id.signinEmail);
        etPassword = findViewById(R.id.signinPassword);
        Button btnLogin = findViewById(R.id.btn_sign_in);

        btnLogin.setOnClickListener(v -> {
            email = etEmail.getText().toString();
            password = etPassword.getText().toString();
            if (email.trim().length() == 0) {
                etEmail.setError("field tidak boleh kosong");
            } else if (password.trim().length() == 0) {
                etPassword.setError("field tidak boleh kosong");
            } else {
                login(email, password);
            }
        });

        TextView link_sign_up = findViewById(R.id.link_sign_up);
        link_sign_up.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);
            startActivity(intent);
        });
    }

    private void login(String email, String password) {
        APIRequestData apiData = RetroServer.konekRetro().create(APIRequestData.class);
        Call<ResponseModel> Signin = apiData.resLogin(email, password);
        Signin.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String pesan = response.body().getPesan();
                String status = response.body().getStatus();

                if (status.equals("1")) {
                    Toast.makeText(getApplicationContext(), "" + pesan, Toast.LENGTH_SHORT).show();
                    getByEmail();
                }else {
                    Toast.makeText(getApplicationContext(), "Login Gagal ", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(SignIn.this, "Error : " +t ,Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void reset() {
        email = "";
        password = "";
        etEmail.setText("");
        etPassword.setText("");
    }

    // get data user by email
    public void getByEmail() {
        APIRequestData apiData = RetroServer.konekRetro().create(APIRequestData.class);
        Call<ResponseModel> userData = apiData.ardGetDataUserByEmail(email);
        userData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String fullname = response.body().getFullname();
                String profile = response.body().getProfile();
                String id = response.body().getId();

                HomeFragment.username = fullname;
                HomeFragment.profile = profile;
                ConfigurationAll.user_id = id;

                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                reset();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                reset();
                Toast.makeText(SignIn.this, "Eror : "+t,  Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}