package com.android.gaoyun.twenty_one;

public class Croupier extends Player{

    int turn;

    public void croupierGame(){

        nowScore = 10;
        nowScore += addCard();

        switch (nowScore){

            case(13):
            case(14):{

                turn = (int) (Math.random()*10);
                if(turn > 3) croupierGame();
                else break;

            }

            case(15):
            case(16):{

                turn = (int) (Math.random()*10);
                if(turn > 6) croupierGame();
                else break;

            }

            case(17):
            case(18):{

                int turn = (int) (Math.random()*10);
                if(turn > 8) croupierGame();
                else break;

            }

            case(19):{

                turn = (int) (Math.random()*10);
                if(turn > 9) croupierGame();
                else break;

            }

            case(20):
            case(21):{

                break;

            }

            default:{

                croupierGame();

            }

        }
    }

}
