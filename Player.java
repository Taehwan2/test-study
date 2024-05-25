package tennis;

public class Player {
    private int score;
    private boolean advantage;

    public Player(int score, boolean advantage) {
        this.score = score;
        this.advantage = advantage;
    }

    public int getScore() {
        return score;
    }

    public boolean isAdvantage() {
        return advantage;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }
}
