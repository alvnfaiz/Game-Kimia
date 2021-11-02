package com.alvindev.aplikasibelajaruts.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alvindev.aplikasibelajaruts.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // gw ngakalin dengan menggunakan theme.xml
        /*getSupportActionBar().hide();*/
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception error) {
                    error.printStackTrace();
                } finally {
                    Intent intentMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intentMain);
                }
            }
        };
        timer.start();
    }
}