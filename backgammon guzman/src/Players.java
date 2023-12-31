/* Name: Guzman Sanchez
 * Class: COP3252
 * Instructor: Dr. Katie Brodhead
 * Title: Players.java
 * Description: Players class creates players and groups them.
 * */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;


public class Players implements Iterable<Player>, Iterator<Player> {
    // Players creates and groups two Players

    public static int NUM_PLAYERS = 2;

    private ArrayList<Player> players;
    private int currentPlayer;
    private Iterator<Player> iterator;

    Players() {
        players = new ArrayList<Player>();
        players.add(new Player(0,"RED", Color.RED));
        players.add(new Player(1,"YELLOW",Color.YELLOW));
        currentPlayer = 0;
    }

    Players(Players players) {
        this.players = new ArrayList<Player>();
        for (Player player : players) {
            this.players.add(new Player(player));
        }
        currentPlayer = 0;
    }

    public void setCurrentAccordingToDieRoll() {
        if (players.get(0).getDice().getDie() > players.get(1).getDice().getDie()) {
            currentPlayer = 0;
        } else {
            currentPlayer = 1;
        }
    }

    public Player getCurrent() {
        return players.get(currentPlayer);
    }

    public void advanceCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer == NUM_PLAYERS) {
            currentPlayer = 0;
        }
    }

    public Player get(int id) {
        return players.get(id);
    }

    public boolean isEqualDice() {
        return players.get(0).getDice().getDie() == players.get(1).getDice().getDie();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Player next() {
        return iterator.next();
    }

    public Iterator<Player> iterator() {
        iterator = players.iterator();
        return iterator;
    }
}