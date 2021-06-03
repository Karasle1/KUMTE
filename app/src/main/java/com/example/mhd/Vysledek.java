package com.example.mhd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Vysledek extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vysledek);
            tvResult = findViewById(R.id.tvResult);
            tvResult.setText(String.valueOf(getIntent().getIntExtra("vysledek",0)));

    }
}