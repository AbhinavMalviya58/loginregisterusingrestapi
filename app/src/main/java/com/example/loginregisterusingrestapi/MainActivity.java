package com.example.loginregisterusingrestapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TextView Login;
    slideViewPagerAdapter slideViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            viewPager = findViewById(R.id.viewpager);
            slideViewPagerAdapter = new slideViewPagerAdapter(this);
            viewPager.setAdapter(slideViewPagerAdapter);
//            if (isOpenAlread()){
//                Intent intent = new Intent(MainActivity.this, login.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }else {
//                SharedPreferences. Editor editor = getSharedPreferences("slide", MODE_PRIVATE).edit();
//                editor.putBoolean("slide", true);
//                editor.commit();
//            }
    }

    private boolean isOpenAlread() {
        SharedPreferences sharedPreferences = getSharedPreferences ("slide", MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("slide", true);
        return result;
    }
}