package com.example.aditisharma.jumbletrouble;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {


    Button b1,b2,b3;
    static MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage.this,jumble1Splash.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage.this,jumble2Splash.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage.this,jumble3Splash.class);
                startActivity(i);
            }
        });
        if(player==null)
        {
            player=MediaPlayer.create(this,R.raw.instrumental);
        }
        Thread mus = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    while(true)
                    {
                        player.start();
                    }

                }
                catch(Exception e)
                {}

            }
        };
        mus.start();
    }
}
