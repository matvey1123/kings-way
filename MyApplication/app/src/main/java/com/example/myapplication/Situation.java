package com.example.myapplication;

//=======ситуация=======
public class Situation {
    public Situation[] direction;
    String subject, text;
    int dB, dD, dH, dT, dA;

    public Situation(String subject, String text, int variants, int db, int dd, int dh, int dt, int da) {
        this.subject = subject;
        this.text = text;
        dB = db;
        dD = dd;
        dH = dh;
        dT = dt;
        dA = da;
        direction = new Situation[variants];
    }
}
