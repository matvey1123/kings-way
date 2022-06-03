package com.example.myapplication;

//=======персонаж=======
public class Character {
    public int B; //вера в короля
    public int D; //деньги
    public int H; //население
    public int T; //территория
    public String name;
    public String country;

    public Character(String name, String country) {
        B = 30;
        D = 700;
        H = 250;
        T = 10;

        this.name = name;
        this.country = country;
    }
}
