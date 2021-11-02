package com.alvindev.aplikasibelajaruts.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alvindev.aplikasibelajaruts.R;

public class BenarActivity extends AppCompatActivity {
    Button lanjut, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benar);
        lanjut = findViewById(R.id.btnLanjut);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanjut = new Intent(BenarActivity.this, GameActivity.class);
                startActivity(lanjut);
            }
        });
        home = findViewById(R.id.btnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(BenarActivity.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}