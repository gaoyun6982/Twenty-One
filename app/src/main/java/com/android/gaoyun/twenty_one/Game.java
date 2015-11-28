package com.android.gaoyun.twenty_one;

public class Game {

    boolean play = true;

    Player userPlayer = new Player();
    Croupier droidCroupier = new Croupier();

    public String playerTurn(){

        userPlayer.nowScore += userPlayer.addCard();
        userPlayer.checkGame = checkScore(userPlayer.nowScore);

        if(!userPlayer.checkGame.equals("lose")) {

            return userPlayer.checkGame;

        }else{

            droidCroupier.totalScore++;
            return userPlayer.checkGame;

        }
    }

    public String croupierGame(){

        droidCroupier.croupierGame();
        return endPart(userPlayer.nowScore, droidCroupier.nowScore);

    }

    public String checkScore(int score){

        if(score >= 21){
            if(score > 21) {
                play = false;
                droidCroupier.totalScore++;
                return "YOU LOSE\nYour score: " + score + "\n\nYour total score: " +
                        + userPlayer.totalScore + "\nCroupier total score: " + droidCroupier.totalScore;
            }
            else{
                play = false;
                userPlayer.totalScore++;
                return "YOU WON\nYour score: " + score + "\n\nYour total score: " +
                        + userPlayer.totalScore + "\nCroupier total score: " + droidCroupier.totalScore;
            }
        }
        else{
            return "WANT ADD ONE MORE CARD?\nYour score: " + score;
        }

    }

    public String endPart(int userScore, int croupierScore){

        play = false;

        if(userScore >= croupierScore) {
            userPlayer.totalScore++;
            return "YOU WON!\nYour score: " + userScore + "\nCroupier score: " + croupierScore + "\n\nYour total score: " +
                    + userPlayer.totalScore + "\nCroupier total score: " + droidCroupier.totalScore;
        }
        else {
            droidCroupier.totalScore++;
            return "YOU LOSE!\nYour score: " + userScore + "\nCroupier score: " + croupierScore + "\n\nYour total score: " +
                    + userPlayer.totalScore + "\nCroupier total score: " + droidCroupier.totalScore;
        }

    }

    public void newPart(){

        userPlayer.nowScore = 0;
        droidCroupier.nowScore = 0;
        play = true;

    }

}
