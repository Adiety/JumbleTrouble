package com.example.aditisharma.jumbletrouble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.aditisharma.jumbletrouble.R.id.score;

public class Result1 extends AppCompatActivity {

    String score;
    TextView tv1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        tv1 = (TextView)findViewById(R.id.tv1);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        int eas= b.getInt("scoreEasy");
        int med= b.getInt("scoreMedium");
        int har= b.getInt("scoreHard");
        int level =b.getInt("J");

        if(level ==1) {

            score = Integer.toString(eas);

            tv1.setText("YOU SCORED "+score+" IN THE EASY LEVEL");
        }
        if(level ==2)
        {
            score= Integer.toString(med);

            tv1.setText("YOU SCORED "+score+" IN THE MEDIUM LEVEL");
        }
        if(level==3)
        {
            score = Integer.toString(har);

            tv1.setText("YOU SCORED "+score+" IN THE HARD LEVEL");
        }


    }
}
