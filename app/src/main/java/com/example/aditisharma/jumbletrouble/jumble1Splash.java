package com.example.aditisharma.jumbletrouble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class jumble1Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumble1_splash);

        Thread t = new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2500);
                }
                catch (Exception e)
                {}
                finish();
                Intent i =new Intent(jumble1Splash.this,Jumble1.class);
                startActivity(i);
            }
        };
        t.start();
    }
}
