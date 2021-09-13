package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Welcome extends AppCompatActivity {
    Handler handle = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I = new Intent(Welcome.this, MainActivity.class);
                startActivity(I);
                finish();
            }
        },2000);
    }
}