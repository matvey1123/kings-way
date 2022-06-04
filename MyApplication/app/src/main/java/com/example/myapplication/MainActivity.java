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
    Character manager; // персонаж
    Story story; // история (сюжет)
    Button bt1,bt2,bt3;
    ImageView swic;
    ProgressBar progressBardD, progressBardB,progressBarH,progressBarBT;
    public Integer count = 0;
  //  ImageView money,vera, people, land;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        money = findViewById(R.id.money);
//        vera = findViewById(R.id.vera);
//        people = findViewById(R.id.people);
//        land = findViewById(R.id.land);
//
//        money.setImageResource(R.drawable.money);
//        vera.setImageResource(R.drawable.vera);
//        people.setImageResource(R.drawable.people);
//        land.setImageResource(R.drawable.land);

        swic = findViewById(R.id.swic);

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
//        ft.add(R.id.place_holder, fb);
//        ft.commit();



        // создаем нового персонажа и историю
        manager = new Character("Вилльям", "Ирландия");
        //story = new StoriesBuilder().build()[randomInt()];
        story = new Story();
        // в первый раз выводим на форму весь необходимый текст и элементы
        // управления
        updateStatus();
    }

    // метод для перехода на нужную ветку развития
    private void go(int i) {
        story.go(i + 1);
        updateStatus();

        if(count == 2)
        ((ImageView) findViewById(R.id.swic)).setImageResource(R.drawable.men2);

        if(count == 4)
            ((ImageView) findViewById(R.id.swic)).setImageResource(R.drawable.men3);

        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!\n" + "Продолжение следует", Toast.LENGTH_LONG).show();
    }




    // в этом методе размещаем всю информацию, специфичную для текущей
    // ситуации на форме приложения, а также размещаем кнопки, которые
    // позволят пользователю выбрать дальнейший ход событий
    private void updateStatus() {
        // не забываем обновить репутацию в соответствии с новым
        // состоянием дел
        manager.B += story.current_situation.dB;
        manager.D += story.current_situation.dD;
        manager.H += story.current_situation.dH;
        manager.T += story.current_situation.dT;

        progressBardD.setProgress(manager.D);
        progressBardB.setProgress(manager.B);
        progressBarH.setProgress(manager.H);
        progressBarBT.setProgress(manager.T);



        // выводим статус на форму
//        ((TextView) findViewById(R.id.status)).
//                setText("Вера в короля:" + manager.B +
//                        "\nДеньги:" + manager.D + "\nНаселение:" + manager.H + "\nТерритория:" + manager.T);

        // аналогично для заголовка и описания ситуации
        ((TextView) findViewById(R.id.title)).
                setText(story.current_situation.subject);
        ((TextView) findViewById(R.id.desc)).
                setText(story.current_situation.text);
        //((LinearLayout) findViewById(R.id.layout)).removeAllViews();
        // размещаем кнопку для каждого варианта, который пользователь
        // может выбрать


//        for (int i = 0; i < story.current_situation.direction.length; i++) {
//            Button b = new Button(this);
//            b.setText(Integer.toString(i + 1));
//            b.setBackgroundColor(RandomColor());
//            final int buttonId = i;


        // Внимание! в анонимных классах
        // можно использовать только те переменные метода,
        // которые объявлены как final.
        // Создаем объект анонимного класса и устанавливаем его
        // обработчиком нажатия на кнопку

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
                count++;
                if((progressBardD.getProgress() <= 0 || progressBardD.getProgress() >= progressBardD.getMax())
                    || (progressBardB.getProgress() <= 0 || progressBardB.getProgress() >= progressBardB.getMax())
                    || (progressBarBT.getProgress() <= 0 || progressBarBT.getProgress() >= progressBarBT.getMax())
                    || (progressBarH.getProgress() <= 0 || progressBarH.getProgress() >= progressBarH.getMax())){
                    over();
                }
                go(id1 - 1);
            }



        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if((progressBardD.getProgress() <= 0 || progressBardD.getProgress() >= progressBardD.getMax())
                        || (progressBardB.getProgress() <= 0 || progressBardB.getProgress() >= progressBardB.getMax())
                        || (progressBarBT.getProgress() <= 0 || progressBarBT.getProgress() >= progressBarBT.getMax())
                        || (progressBarH.getProgress() <= 0 || progressBarH.getProgress() >= progressBarH.getMax())){
                    over();
                }
                go(id2 - 1);

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if((progressBardD.getProgress() <= 0 || progressBardD.getProgress() >= progressBardD.getMax())
                        || (progressBardB.getProgress() <= 0 || progressBardB.getProgress() >= progressBardB.getMax())
                        || (progressBarBT.getProgress() <= 0 || progressBarBT.getProgress() >= progressBarBT.getMax())
                        || (progressBarH.getProgress() <= 0 || progressBarH.getProgress() >= progressBarH.getMax())){
                    over();
                }
                go(id3 - 1);
            }
        });




//            @Override
//                    protected void onProgressUpdate(){
//                super.onProgressUpdate(a);
//            progressBardD.setProgress(manager.D);
//            progressBardB.setProgress(manager.B);
//            progressBarH.setProgress(manager.H);
//            progressBarBT.setProgress(manager.T);
//
//
//        }



//            b.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    go(buttonId);
//                    // поскольку анонимный класс имеет полный
//                    // доступ к методам и переменным родительского,
//                    // то просто вызываем нужный нам метод.
//                }
//            });
        // добавляем готовую кнопку на разметку
        //((LinearLayout) findViewById(R.id.layout)).addView(b);
    }


    public void over(){
        ((ImageView) findViewById(R.id.swic)).setImageResource(R.drawable.over);
        Toast.makeText(this, "Игра закончена!\nКороль убит", Toast.LENGTH_LONG).show();
    }

    //public void refreshCounter(){
//        textView.setText(String.valueOf(count));
//    }


//    public void ButtonActivity(Button x, Button y, Button z) {
//        x.setBackgroundColor(color2);
//        y.setBackgroundColor(color1);
//
//        prevcolor = color2;
//        color2 = color1;
//        color1 = prevcolor;
//
//    }


//    protected void onPause() {
//        super.onPause();
//        color1 = RandomColor();
//        color2 = RandomColor();
//        bt1.setBackgroundColor(color1);
//        bt2.setBackgroundColor(color2);
//        prevcolor = color1;
//    }

     //private int RandomColor() {
      //  return Color.rgb(randomInt(), randomInt(), randomInt());
    //}


// Приостановить обновления UI, потоки или трудоемкие процессы, // ненужные, когда активность не на переднем плане } // Вызывается перед выходом из видимого состояния @Override protected void onStop() { super.onStop(); // Приостановить обновления UI, потоки ненужные, когда активность не на переднем плане. // Сохранить все данные и изменения в UI. } // Вызывается перед уничтожением активности @Override protected void onDestroy() { super.onDestroy(); // Освободить все ресурсы, включая работающие потоки, соединения с БД. }
}



