package com.example.quantitymeasurement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.view.WindowManager;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);

    }
}