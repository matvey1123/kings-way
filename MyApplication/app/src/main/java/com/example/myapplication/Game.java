package com.example.myapplication;

import com.example.myapplication.thread.StoriesBuilder;

import java.util.Scanner;

//=======игра=======
public class Game {

    public static Character manager;
    public static Story story;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Вам по наследству достался трон, теперь госудраство полностью под Вашим контролем. \n "
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):\n"
                + "Как пожелаете обозвать государство?");
        manager = new Character(in.next(), in.next());
        story = new Story();
        //story = new StoriesBuilder().build()[1];
        while (true) {
            manager.B += story.current_situation.dB;
            manager.D += story.current_situation.dD;
            manager.H += story.current_situation.dH;
            manager.T += story.current_situation.dT;
            System.out.println("=====\nВера в короля:" + manager.B + "\tДеньги:"
                    + manager.D + "\tНаселение:" + manager.H + "\tТерритория:" + manager.T +
                    "\n=====");
            System.out.println("============="
                    + story.current_situation.subject + "==============");
            System.out.println(story.current_situation.text);
            if (story.isEnd()) {
                System.out
                        .println("====================the end!===================");
                return;
            }
            story.go(in.nextInt());
        }

    }



}
