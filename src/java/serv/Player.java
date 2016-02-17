package serv;

import static java.lang.Math.random;

/**
 *
 * @author Vasil Talkachou
 */
public class Player {

    private int points;
    private String name;

    public Player(String name) {
        points = 0;
        this.name = name;
    }

    public void restart() {
        points = 0;
    }

    public void getCard() {
        int newCard = (int) (random() * 10 + 2);
        points += newCard;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public boolean isLost() {
        return points > 21;
    }

    public boolean isWin() {
        return points == 21;
    }
}
