package com.example.loginregisterusingrestapi.backend;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("user/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("user/register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest userRequest);
}
