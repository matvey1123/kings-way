package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Character manager;
    Story story;
    Button bt1, bt2, bt3;
    ProgressBar progressBardD, progressBardB, progressBarH, progressBarBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBardD = findViewById(R.id.progressBardD);
        progressBardB = findViewById(R.id.progressBardB);
        progressBarH = findViewById(R.id.progressBarH);
        progressBarBT = findViewById(R.id.progressBarBT);

        progressBardD.setMax(1400);
        progressBardB.setMax(60);
        progressBarH.setMax(500);
        progressBarBT.setMax(20);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        BlankFragment fb = new BlankFragment();
        ft.add(R.id.place_holder, fb);
        ft.commit();


        manager = new Character("Вилльям", "Ирландия");

        story = new Story();

        updateStatus();
    }

    private void go(int i) {
        story.go(i + 1);
        updateStatus();

        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!\n" + "Продолжение следует", Toast.LENGTH_LONG).show();
    }


    private void updateStatus() {

        manager.B += story.current_situation.dB;
        manager.D += story.current_situation.dD;
        manager.H += story.current_situation.dH;
        manager.T += story.current_situation.dT;

        progressBardD.setProgress(manager.D);
        progressBardB.setProgress(manager.B);
        progressBarH.setProgress(manager.H);
        progressBarBT.setProgress(manager.T);


        ((TextView) findViewById(R.id.title)).
                setText(story.current_situation.subject);
        ((TextView) findViewById(R.id.desc)).
                setText(story.current_situation.text);


        final int id1 = 1;
        final int id2 = 2;
        final int id3 = 3;

        this.bt1 = findViewById(R.id.bt1);
        this.bt2 = findViewById(R.id.bt2);
        this.bt3 = findViewById(R.id.bt3);
        bt1.setText(Integer.toString(id1));
        bt2.setText(Integer.toString(id2));
        bt3.setText(Integer.toString(id3));


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((progressBardD.getProgress() <= 0 || progressBardD.getProgress() >= progressBardD.getMax())
                        || (progressBardB.getProgress() <= 0 || progressBardB.getProgress() >= progressBardB.getMax())
                        || (progressBarBT.getProgress() <= 0 || progressBarBT.getProgress() >= progressBarBT.getMax())
                        || (progressBarH.getProgress() <= 0 || progressBarH.getProgress() >= progressBarH.getMax())) {
                    over();
                }
                go(id1 - 1);
            }


        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((progressBardD.getProgress() <= 0 || progressBardD.getProgress() >= progressBardD.getMax())
                        || (progressBardB.getProgress() <= 0 || progressBardB.getProgress() >= progressBardB.getMax())
                        || (progressBarBT.getProgress() <= 0 || progressBarBT.getProgress() >= progressBarBT.getMax())
                        || (progressBarH.getProgress() <= 0 || progressBarH.getProgress() >= progressBarH.getMax())) {
                    over();
                }
                go(id2 - 1);

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((progressBardD.getProgress() <= 0 || progressBardD.getProgress() >= progressBardD.getMax())
                        || (progressBardB.getProgress() <= 0 || progressBardB.getProgress() >= progressBardB.getMax())
                        || (progressBarBT.getProgress() <= 0 || progressBarBT.getProgress() >= progressBarBT.getMax())
                        || (progressBarH.getProgress() <= 0 || progressBarH.getProgress() >= progressBarH.getMax())) {
                    over();
                }
                go(id3 - 1);
            }
        });


    }


    public void over() {
        Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }
}



