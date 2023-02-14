import board.Board;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Die die;
    private final Queue<Pair<Player, Integer>> players;
    private final StringBuilder result;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.die = new Die();
        this.players = new LinkedList<>();
        for(Player player: players) {
            this.players.add(new Pair<>(player, 0));
        }
        result = new StringBuilder();
    }

    public void play() {
        while(!players.isEmpty()) {
            Player player = players.peek().getKey();
            int currPosition = players.peek().getValue();
            players.remove();

            StringBuilder message = new StringBuilder();
            int newPosition = rollDie(currPosition, message);

            result.append(String.format("Player: %s \t Position: %d \t %s \t new Position: %d\n",
                    player.getName(), currPosition, message, newPosition));
            if (newPosition != board.getnSquares()) {
                players.add(new Pair<>(player, newPosition));
            } else {
                result.append(String.format("\n\t\t\t%s completed the game.\n\n", player.getName()));
            }
        }
    }

    private int rollDie(int position, StringBuilder message) {
        int value = die.rollDie();
        message.append(String.format("Roll: %s \t ", value));

        if(position + value < board.getnSquares()) {
            position += value;
            int prevPosition = position;
            position = board.next(position);

            if(position > prevPosition) {
                message.append("Climbed ladder.");
            } else if(position < prevPosition) {
                message.append("Snake bite.. Going down.");
            }
        } else if(position + value == board.getnSquares()) {
            position += value;
            message.append("Hurray! reached the end.");
        } else {
            message.append("need less steps than current roll to reach the end.");
        }

        return position;
    }

    public String getResult() {
        return result.toString();
    }
}
