package com.example.myapplication.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class MainActivity1 extends AppCompatActivity {
    Button bStart, btJustDoIt;
    ProgressBar progressBar;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStart = (Button) findViewById(R.id.btStart);
        btJustDoIt= (Button) findViewById(R.id.btJustDoIt);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        text = (TextView) findViewById(R.id.text);
        // устанавливаем обработчик на кнопку "Начать в потоке"
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity1.this, "Делаем операцию в потоке (10с)", Toast.LENGTH_SHORT).show();
                new LoadImage().execute();
            }
        });
        // устанавливаем обработчик на кнопку "Начать не в потоке"
        btJustDoIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity1.this, "Делаем операцию не в потоке (10с)", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // объект потока
    private class LoadImage extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Void... args) {
            for (int i = 0; i < 100; i += 10) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(100);
            return null;
        }
        protected void onPostExecute(Void image) {
            text.setText("Задача завершена");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            text.setText("Выполнено : " + values[0] + "/100");
        }
    }
}
