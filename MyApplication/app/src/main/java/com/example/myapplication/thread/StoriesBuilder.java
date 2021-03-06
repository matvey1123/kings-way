package com.example.myapplication.thread;

import com.example.myapplication.Situation;
import com.example.myapplication.Story;

public class StoriesBuilder {
    public Story[] build() {
        Story[] stories = new Story[10];


        Situation start_story0 = new Situation(
                "Сцена первая, Знакомство",
                "Приветствую, мой король!\n "
                        + "Рядом с нами граничит слабенькое государство, что прикажете сделать?\n"
                        + "(1)Немедленно отправить войско и подчинить эту территорию нам\n"
                        + "(2)Мы еще недостаточно сильны, чтобы проводить военные действия\n"
                        + "(3)Отправить делегацию и настроить торговые отношения ",
                3, 0, 0, 0, 0, 0);




        //Situation[] direction0 = new Situation[3];

        start_story0.direction[0] = new Situation(
                "Успех, мы захватили соседний участок",
                "Поздравляю, Ваше Высочество, мы подчинили себе соседнее королевство и теперь мы стали сильнее!\n "
                        + "Возрадуйтесь и ознакомьтесь с нашими ресурсами сейчас",
                0, +15, +500, +200, +3, +100);

        start_story0.direction[0].direction[0]= new Situation("","",0,0,0,0,0,0);

        start_story0.direction[1] = new Situation(
                "Накапливаем силы",
                "Король, для этого нужны ресурсы, пришлось потратить 200 тыс на армию",
                0, 0, -200, 0, 0, 0);

        start_story0.direction[1].direction[0]= new Situation("","",0,0,0,0,0,0);

        start_story0.direction[2] = new Situation(
                "Переговоры сорвались.",
                "Переговоры сорвались, наши 5 делегатов убиты, доходят вести, что они готовятся к войне.\n"
                        + " Народ настроен воинственно и недоволен политикой короля \n"
                        + " Король, нужно быть готовым к войне!", 0, -10, -10, -5, 0, 0);


      //  stories[0] = new Story(start_story0, start_story0.direction);
//             start_story.direction[0] = new Situation(
//                     "Успех, мы захватили соседний участок",
//                     "Поздравляю, Ваше Высочество, мы подчинили себе соседнее королевство и теперь мы стали сильнее!\n "
//                             + "Возрадуйтесь и ознакомьтесь с нашими ресурсами сейчас",
//                     0, +15, +500, +200, +3, +100);
//        start_story.direction[1] = new Situation(
//                "Накапливаем силы",
//                "Король, для этого нужны ресурсы, пришлось потратить 200 тыс на армию",
//                0, 0, -200,0,0,0);
//        start_story.direction[2] = new Situation(
//                "Переговоры сорвались.",
//                "Переговоры сорвались, наши 5 делегатов убиты, доходят вести, что они готовятся к войне.\n"
//                        + " Народ настроен воинственно и недоволен политикой короля \n"
//                        + " Король, нужно быть готовым к войне!", 0, -10, -10,-5,0,0);
//
//
//        current_situation = start_story;

        Situation start_story1 = new Situation("Банда проникла в сокровищницу",
                "Какие то негодяи смогли обхитрить стражу и замки, что с ними делать?\n"
                        + "(1)Немедленно казнить\n" + "(2)Выяснить, как они сумели и предоставить должность главного по безопасности\n"
                        + "(3)Помиловать",
                3, 0, 0, 0, 0, 0);

        //Situation[] direction1 = new Situation[3];

        start_story1.direction[0] = new Situation("Казнь прошла",
                "Удалось казнить двух из трех, один убежал, народ в панике",
                0, -5, -100, 0, 0, 0);

        start_story1.direction[1] = new Situation("Допрос произведен",
                "Выяснили все уловки и слабости, уже исправляем\n"
                        + "На должность согласились",
                0, 0, +200, 0, 0, 0);

        start_story1.direction[2] = new Situation("Помиловали",
                "Народ недоволен решением короля помиловать, эта банда ворует у обычных людей",
                0, -10, -100, 0, 0, 0);

     //   stories[1] = new Story(start_story1, start_story1.direction);

        Situation start_story2 = new Situation("Установка отношений",
                "Король Ричард из соседнего государства прислал 50 книг, строим библиотеку?\n"
                        +"(1)Нам не нужно настраивать отношения, гонца убить, книги сжечь\n"+
                        "(2)Отправить книги обратно\n"
                        +"(3)Построить библиотеку и пускать туда всех желающих. Королю послать наши лучшие одеяния",
                3,0,0,0,0,0);

       //Situation[] direction2 = new Situation[3];

        start_story2.direction[0] = new Situation("Ричард в гневе",
                "Король Ричард узнал, что случилось с огнцом и книгами и теперь готовится к войне, надо вооружаться",
                0,0, -300,0,0,0);

        start_story2.direction[1] = new Situation("Король Ричард недоволен и хочет лично пообщаться",
                "Стоит пригласить короля, устроим праздник",
                0,+10,-50,0,0,0);

        start_story2.direction[2] = new Situation("Библиотека построена",
                "Пришлось потратить деньги на постройку, но наши торговые отношения налажены и мы окупились, даже заработали!",
                0,15,500,100,0,50);

      //  stories[2] = new Story(start_story2,start_story2.direction);
        return stories;
    }

        Situation start_story3 = new Situation("Безграммотность растет",
                "Король, уровень безграмотности растет, народ тупеет, торговцев обманывают соседние государства, строим школы?\n" +
                "(1)Оставить все без изменений, у нас нет достаточно золота, чтобы этим заниматься \n "+
                "(2)Построить одну школу, пускай учатся только дети знати \n"+
                "(3)Построить несколько школ, пускай учатся все способные дети, пригласить иностранных учителей",
                3,0,0,0,0,0);

        //start_story3.direction[0]= =

}


//    public Story(Situation start_story) {
//        start_story = new Situation(
//                "Сцена первая, Знакомство",
//                "Приветствую, мой король!\n "
//                        + "Рядом с нами граничит слабенькое государство, что прикажете сделать?\n"
//                        + "(1)Немедленно отправить войско и подчинить эту территорию нам\n"
//                        + "(2)Мы еще недостаточно сильны, чтобы проводить военные действия\n"
//                        + "(3)Отправить делегацию и настроить торговые отношения ",
//                3, 0,0,0,0,0);
//        start_story.direction[0] = new Situation(
//                "Успех, мы захватили соседний участок",
//                "Поздравляю, Ваше Высочество, мы подчинили себе соседнее королевство и теперь мы стали сильнее!\n "
//                        + "Возрадуйтесь и ознакомьтесь с нашими ресурсами сейчас",
//                0, +15, +500, +200, +3, +100);
//        start_story.direction[1] = new Situation(
//                "Накапливаем силы",
//                "Король, для этого нужны ресурсы, пришлось потратить 200 тыс на армию",
//                0, 0, -200,0,0,0);
//        start_story.direction[2] = new Situation(
//                "Переговоры сорвались.",
//                "Переговоры сорвались, наши 5 делегатов убиты, доходят вести, что они готовятся к войне.\n"
//                        + " Народ настроен воинственно и недоволен политикой короля \n"
//                        + " Король, нужно быть готовым к войне!", 0, -10, -10,-5,0,0);
//
//
//        current_situation = start_story;
//    }