package com.alvindev.aplikasibelajaruts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Create thread for sleep until 2 seconds.
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch(Exception error){
                    error.printStackTrace();
                }finally{
                    Intent intentMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intentMain);
                }
            }
        };
        timer.start();
    }
}