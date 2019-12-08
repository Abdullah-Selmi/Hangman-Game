package com.example.hangmangame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int length, yes = 0, f = 6 , time = 0 , score = 0;
    String s = "" , s2;
    String[] a = {"cat", "monkey", "rat", "fox", "lion" , "cow", "snake" , "whale" , "horse" , "donkey" , "tiger" , "bear" , "bird" , "dog" , "wolf" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r = new Random();
        int w = r.nextInt(15);
        TextView t = (TextView) findViewById(R.id.text1);
        length = a[w].length();
        s2 = a[w];
        for(int j=0; j<length; j++) {
            s+="?";
        }
        t.setText(s);
        s = "";
    }

    public void guess(View view) {
        EditText t2 = (EditText) findViewById(R.id.ed1);
        TextView t = (TextView) findViewById(R.id.text1);
        if(t2.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Enter A Letter To Play", Toast.LENGTH_SHORT).show();
        }
        else {
            char ltr = t2.getText().toString().toLowerCase().charAt(0);
            int idx = s2.indexOf(String.valueOf(ltr).toLowerCase());
            String txt = t.getText().toString();
            if(idx != -1) {
                String ab = String.valueOf(ltr);
                if (t.getText().toString().contains(ab)) {

                    Toast.makeText(this, "You already guessed this letter, please enter another one", Toast.LENGTH_SHORT).show();
                }
                else {
                    t.setText(txt.substring(0, idx) + ab.toLowerCase() + txt.substring(idx + 1));
                    yes++;
                }
            }
            else {
                f--;
            }
        }
        t2.setText("");
        if (f == 5) {
            ImageView iv = (ImageView) findViewById(R.id.i5);
            iv.setVisibility(View.VISIBLE);
            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText("You have 5 guesses left");
        } else if (f == 4) {
            ImageView iv = (ImageView) findViewById(R.id.i4);
            iv.setVisibility(View.VISIBLE);
            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText("You have 4 guesses left");
        } else if (f == 3) {
            ImageView iv = (ImageView) findViewById(R.id.i3);
            iv.setVisibility(View.VISIBLE);
            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText("You have 3 guesses left");
        } else if (f == 2) {
            ImageView iv = (ImageView) findViewById(R.id.i2);
            iv.setVisibility(View.VISIBLE);
            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText("You have 2 guesses left");
        } else if (f == 1) {
            ImageView iv = (ImageView) findViewById(R.id.i1);
            iv.setVisibility(View.VISIBLE);
            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText("You have 1 guess left");
        } else if (f == 0) {
            ImageView iv = (ImageView) findViewById(R.id.i0);
            iv.setVisibility(View.VISIBLE);
            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText("You have 0 guesses left");
        }
        if(time == 14)
        {
            if(f == 0)
            {
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Press (NEW) To Start The Game Again", Toast.LENGTH_LONG).show();
                Button button = (Button) findViewById(R.id.b1);
                button.setVisibility(View.INVISIBLE);
                TextView b1a = (TextView) findViewById(R.id.b1a);
                b1a.setVisibility(View.VISIBLE);
                time++;
            }else if(yes == length)
            {
                Toast.makeText(this, "Right Answer", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Press (NEW) To Start The Game Again", Toast.LENGTH_LONG).show();
                Button button = (Button) findViewById(R.id.b1);
                button.setVisibility(View.INVISIBLE);
                TextView b1a = (TextView) findViewById(R.id.b1a);
                b1a.setVisibility(View.VISIBLE);
                time++;
                score++;
            }
        }else {
            if(f == 0)
            {
                Toast.makeText(this, "Wrong Answer , Press (NEW) To Have A New Word ", Toast.LENGTH_LONG).show();
                Button button = (Button) findViewById(R.id.b1);
                button.setVisibility(View.INVISIBLE);
                TextView b1a = (TextView) findViewById(R.id.b1a);
                b1a.setVisibility(View.VISIBLE);
                time++;
            }else if(yes == length)
            {
                Toast.makeText(this, "Right Answer , Press (NEW) To Have A New Word ", Toast.LENGTH_LONG).show();
                Button button = (Button) findViewById(R.id.b1);
                button.setVisibility(View.INVISIBLE);
                TextView b1a = (TextView) findViewById(R.id.b1a);
                b1a.setVisibility(View.VISIBLE);
                time++;
                score++;
            }
        }
        for(int i=0 ; i<=15 ; i++)
        {
            if(time == i)
            {
                TextView tt1 = (TextView) findViewById(R.id.text_time);
                tt1.setText("Games Played : " + time + "/15");
            }
        }

        for(int i=0 ; i<=15 ; i++)
        {
            if(score == i)
            {
                TextView tt2 = (TextView) findViewById(R.id.text_score);
                tt2.setText("Score : " + score + "/15");
            }
        }
    }

    public void New_Button(View view) {
        Button button = (Button) findViewById(R.id.b1);
        button.setVisibility(View.VISIBLE);
        TextView b1a = (TextView) findViewById(R.id.b1a);
        b1a.setVisibility(View.INVISIBLE);
        if(time == 15)
        {
            time = 0;
            TextView tt2 = (TextView) findViewById(R.id.text_time);
            tt2.setText("Games Played : " + time + "/15");
            score = 0;
            TextView last = (TextView) findViewById(R.id.text_score);
            last.setText("Score : " + score + "/15");
        }
        TextView t3 = (TextView) findViewById(R.id.t3);
        t3.setText("You have 6 guesses left");
        ImageView iv6 = (ImageView) findViewById(R.id.i6);
        iv6.setVisibility(View.VISIBLE);
        ImageView iv5 = (ImageView) findViewById(R.id.i5);
        iv5.setVisibility(View.INVISIBLE);
        ImageView iv4 = (ImageView) findViewById(R.id.i4);
        iv4.setVisibility(View.INVISIBLE);
        ImageView iv3 = (ImageView) findViewById(R.id.i3);
        iv3.setVisibility(View.INVISIBLE);
        ImageView iv2 = (ImageView) findViewById(R.id.i2);
        iv2.setVisibility(View.INVISIBLE);
        ImageView iv1 = (ImageView) findViewById(R.id.i1);
        iv1.setVisibility(View.INVISIBLE);
        ImageView iv0 = (ImageView) findViewById(R.id.i0);
        iv0.setVisibility(View.INVISIBLE);
        Random r = new Random();
        int w = r.nextInt(15);
        TextView t = (TextView) findViewById(R.id.text1);
        length = a[w].length();
        s2 = a[w];
        for(int j=0; j<length; j++) {
            s+="?";
        }
        t.setText(s);
        s = "";
        f = 6;
        yes = 0;
    }
}