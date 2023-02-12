import board.Board;

public class Game {
    final Board board;
    private final Player[] players;
    private final StringBuilder result;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        result = new StringBuilder();
    }

    public void play() {
        int n = players.length;
        int playersFinished = 0;
        while(playersFinished < n) {
            for (Player player : players) {
                if (!player.isReachedLastSquare()) {
                    StringBuilder message = new StringBuilder();
                    result.append(String.format("Player: %s \t Position: %d \t Roll: %d \t %s \t new Position: %d\n",
                            player.getName(), player.getPosition(), player.roll(message), message,
                            player.getPosition()));
                    if (player.isReachedLastSquare()) {
                        playersFinished++;
                        result.append(String.format("\t\t\t%s completed the game.\n", player.getName()));
                    }
                }
            }
            result.append("\n");
        }
    }

    public String getResult() {
        return result.toString();
    }
}
