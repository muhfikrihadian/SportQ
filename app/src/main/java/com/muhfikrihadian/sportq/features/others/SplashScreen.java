package com.muhfikrihadian.sportq.features.others;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.muhfikrihadian.sportq.R;

public class SplashScreen extends AppCompatActivity {
    private int time=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home=new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(home);
                finish();

            }
        },time);
    }

}
