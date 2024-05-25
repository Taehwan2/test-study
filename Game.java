package tennis;

public class Game {

    public String checkGamePoint(Player player1, Player player2,GameScore gameScore){
         Integer score1 = 0;
         Integer score2 = 0;

        //Deuce
        if(player1.getScore() == player2.getScore() && player1.getScore()>=40 && player2.getScore()>=40){
            player1.setAdvantage(false);
            player2.setAdvantage(false);
        }

        //1 score
        if(player1.getScore()>=40 && player1.getScore() - player2.getScore() >= 1){
            player1.setAdvantage(true);
        }

        //1 score
        if(player1.getScore()>=40 && player1.getScore() - player2.getScore() <= -1){
            player1.setAdvantage(true);
        }


        if(player1.getScore()>=40 && player1.isAdvantage() && player1.getScore() - player2.getScore() >= 2 ){
            score1++;
        }
        if(player2.getScore()>=40 && player2.isAdvantage() && player1.getScore() - player2.getScore() <= -2){
            score2++;
        }

        System.out.println(score1);
        System.out.println(score2);

        //subgame detect
        if(score1!=0) gameScore.setUser1Score(gameScore.getUser1Score());
        else gameScore.setUser2Score(gameScore.getUser2Score()+1);

        System.out.println(gameScore.getUser2Score());
        if(gameScore.getUser1Score()>=3 && gameScore.getUser1Score() - gameScore.getUser2Score()>=2){
            return "user 1 win";
        }
        else if(gameScore.getUser2Score()>=3 && gameScore.getUser1Score() - gameScore.getUser2Score()<=-2){
            return "user 2 win";
        }
        else if(gameScore.getUser1Score()==gameScore.getUser2Score() && gameScore.getUser1Score()>=3){
            return "Deuce";
        }else  return "game running";

    }
}
