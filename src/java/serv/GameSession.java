package serv;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vasil Talkachou
 */
public class GameSession {

    private static ArrayList<Player> players = new ArrayList<>();

    static Player getPlayer(String name, HttpSession session) {
        Player player;
        if (session.getAttribute(name) == null) {
            player = new Player(name);
            players.add(player);
            session.setAttribute(name, player);
        } else {
            player = (Player) session.getAttribute(name);
        }
        return player;
    }

}
