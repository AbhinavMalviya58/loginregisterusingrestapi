package com.example.loginregisterusingrestapi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginregisterusingrestapi.backend.ApiClient;
import com.example.loginregisterusingrestapi.backend.LoginRequest;
import com.example.loginregisterusingrestapi.backend.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    TextView CreateAccountLink;
    EditText signup_email,signup_password;
    TextView forgot_password;
    private CheckBox showPassword;
    Button Login_button;
    ImageView Google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CreateAccountLink = findViewById(R.id.CreateAccountLink);
        signup_email = findViewById(R.id.signup_email);
        signup_password  = findViewById(R.id.signup_password);
        forgot_password = findViewById(R.id.forgot_password);
        showPassword = findViewById(R.id.showPassword);
        Login_button = findViewById(R.id.Login_button);
        Google = findViewById(R.id.google);

        CreateAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, Singup.class));
            }
        });
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, com.example.loginregisterusingrestapi.forgot_password.class));
            }
        });
        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    signup_password.setTransformationMethod(null);
                }else {
                    signup_password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(signup_email.getText().toString()) || TextUtils.isEmpty(signup_password.getText().toString())){
                    String message = "login successfully";
                    Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, donePage.class));
                    finish();
                }else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(signup_email.getText().toString());
                    loginRequest.setPassword(signup_password.getText().toString());
                    loginUser(loginRequest);
                }
            }

            private void loginUser(LoginRequest loginRequest) {
                Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);

                loginResponseCall.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if(response.isSuccessful()){
                            LoginResponse loginResponse = response.body();
                            startActivity(new Intent(login.this, donePage.class));
                            finish();
                        }else {
                            String message = "please try again later";
                            Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        String message = t.getLocalizedMessage();
                        Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}