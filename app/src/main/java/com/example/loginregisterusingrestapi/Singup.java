package com.example.loginregisterusingrestapi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginregisterusingrestapi.backend.ApiClient;
import com.example.loginregisterusingrestapi.backend.RegisterRequest;
import com.example.loginregisterusingrestapi.backend.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Singup extends AppCompatActivity {
TextView Login;
EditText name, signup_email, phone, signup_password, re_signup_password;
Button signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_singup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.name);
        signup_email = findViewById(R.id.signup_email);
        phone = findViewById(R.id.phone);
        signup_password = findViewById(R.id.signup_password);
        signup_button = findViewById(R.id.signup_button);
        re_signup_password = findViewById(R.id.re_signup_password);
        Login = findViewById(R.id.loginBack);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Singup.this, login.class));
            }
        });
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(signup_email.getText().toString()) || TextUtils.isEmpty(phone.getText().toString()) || TextUtils.isEmpty(signup_password.getText().toString())){
                    String message = "input all required fields";
                    Toast.makeText(Singup.this, message, Toast.LENGTH_SHORT).show();
                }else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setFullName(name.getText().toString());
                    registerRequest.setEmail(signup_email.getText().toString());
                    registerRequest.setPhone(phone.getText().toString());
                    registerRequest.setPassword(signup_password.getText().toString());
                    registerUser(registerRequest);
                }
            }
        });
    }

    public void registerUser(RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    String message = "successfully";
                    Toast.makeText(Singup.this, message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Singup.this, farmInfo.class));
                    finish();
                }else {
                    String message = "please try again later";
                    Toast.makeText(Singup.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(Singup.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}