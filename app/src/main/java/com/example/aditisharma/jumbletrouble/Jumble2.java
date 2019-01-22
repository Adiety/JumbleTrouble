package com.example.aditisharma.jumbletrouble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Jumble2 extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,next,check,endGame;
    ImageButton clear;
    TextView tv1,Result,score;
    double val = Math.random()*DataDemo.RealWord.length;
    int r =(int)val;
    int s=0,gameCount=0;
    String currentWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumble2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        next=(Button)findViewById(R.id.next);
        check=(Button)findViewById(R.id.check);
        clear=(ImageButton)findViewById(R.id.clear);
        score=(TextView)findViewById(R.id.score);
        tv1=(TextView)findViewById(R.id.tv1);
        Result=(TextView)findViewById(R.id.Result);

        newGame();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = tv1.getText().toString();

                if(input.equalsIgnoreCase(currentWord))
                {
                    Result.setText("Awesome!");
                    s+=1;
                    score.setText("Score:"+s+"/"+gameCount);
                }
                else
                {
                    Result.setText("Wrong Answer \nCorrect Word :"+currentWord);
                    score.setText("Score:"+s+"/"+gameCount);
                }
                check.setEnabled(false);
                next.setEnabled(true);
                gameCount++;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
                tv1.setText("");
                Result.setText("");
                //gameCount++;

                if (gameCount == 11)
                {
                    Intent i = new Intent(Jumble2.this,Result1.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("scoreMedium",s);
                    bundle.putInt("J",2);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String EntWord = tv1.getText().toString();
                if(EntWord.length()>1)
                {
                    EntWord = EntWord.substring(0,EntWord.length()-1);
                    tv1.setText(EntWord);
                }
                else if (EntWord.length()<=1)
                {
                    tv1.setText("");
                }
            }
        });
    }
    private void newGame( )
    {
        currentWord = DataDemo.FiveLetter[r];
        ShuffleWord();
        r++;
        gameCount++;
        check.setEnabled(true);
        next.setEnabled(false);
    }
    private void ShuffleWord( )
    {
        ArrayList<Character> coll = new ArrayList<Character>();
        for(char c : currentWord.toCharArray()){
            coll.add(c);
        }
        Collections.shuffle(coll);
        b1.setText(coll.get(0).toString());
        b2.setText(coll.get(1).toString());
        b3.setText(coll.get(2).toString());
        b4.setText(coll.get(3).toString());
        b5.setText(coll.get(4).toString());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.append(b1.getText().toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.append(b2.getText().toString());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.append(b3.getText().toString());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.append(b4.getText().toString());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.append(b5.getText().toString());
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i =new Intent(this,MainPage.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.jumble2menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menu_id = item.getItemId();
        if(menu_id == R.id.omi1)
        {
            Intent i =new Intent(Jumble2.this,MainPage.class);
            startActivity(i);

        }
        else if (menu_id==R.id.omi2)
        {
            Intent i = new Intent(Jumble2.this,Jumble1.class);
            startActivity(i);
        }
        else if (menu_id==R.id.omi3)
        {
            Intent i = new Intent(Jumble2.this,Jumble3.class);
            startActivity(i);
        }
        else if(menu_id==R.id.omi4)
        {
            finish();
        }
        else if(menu_id == R.id.omi5)
        {

        }

        return super.onOptionsItemSelected(item);
    }
}

