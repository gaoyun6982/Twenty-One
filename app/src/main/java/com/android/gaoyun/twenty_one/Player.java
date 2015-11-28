package com.android.gaoyun.twenty_one;

public class Player{

    int nowScore = 0;
    int totalScore = 0;
    int addScore = 0;
    String checkGame = "";

    public int addCard(){

        addScore = (int) (Math.random()*11);
        while(addScore < 2) addScore = (int) (Math.random()*11);
        return addScore;

    }

}
