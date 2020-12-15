package com.example.appbrain;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score=0;
    TextView pointsTextView;
    TextView resultTextView;
    TextView timeTextView;
    int numberofquestions=0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView textView;




    public void generatequestion(){

        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        int c=a+b;

        textView.setText(Integer.toString(a)+ "+" +Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(3);
        answers.clear();

        int incorrectanswer;

        for(int i=1;i<5;i++)
        {
            if(i==locationOfCorrectAnswer)
            {
                answers.add(c);
            }
            else
            {

                incorrectanswer=rand.nextInt(42);
                if (incorrectanswer==a+b)
                {
                    incorrectanswer=rand.nextInt(42);
                }
                answers.add(incorrectanswer);
            }
        }

        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));

    }

    public void chooseanswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
        {
            score++;
            resultTextView.setText("Correct!");

        }
        else
        {
            resultTextView.setText("Incorrect");

        }
        numberofquestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberofquestions));
        generatequestion();
    }




    public void fade(View view){

        button=findViewById(R.id.playButton);
         button.animate().alpha(0f).setDuration(1000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.playButton);
        textView=findViewById(R.id.sumtextview);
        button1=findViewById(R.id.option1);
        button2=findViewById(R.id.option2);
        button3=findViewById(R.id.option3);
        button4=findViewById(R.id.option4);

        resultTextView=findViewById(R.id.resultTextView);
        pointsTextView=findViewById(R.id.pointstextview);
        timeTextView=findViewById(R.id.timetextview);


       generatequestion();



    }
}
