package tennis;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisTest {


    @Test
    public void testTennis3() {
        Game game = new Game();
        Player player1 = new Player(30,false);
        Player player2 = new Player(41,true);
        GameScore gameScore = new GameScore(2,3);

        String winner = game.checkGamePoint(player1, player2,gameScore);
        Assertions.assertEquals(winner,"user 2 win");
    }

}
