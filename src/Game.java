import board.Board;

public class Game {
    Board board;
    Player[] players;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    void play() {
        int n = players.length;
        int playersFinished = 0;
        while(playersFinished < n) {
            for (Player player : players) {
                if (!player.isReachedLastSquare()) {
                    System.out.printf("Player: %s \t Position: %d \t Roll: %d \t new Position: %d\n", player.getName(),
                            player.getPosition(), player.roll(), player.getPosition());
                    if (player.isReachedLastSquare()) {
                        playersFinished++;
                        System.out.println("Player " + player.getName() + " completed the game.");
                    }
                }
            }
        }
    }
}
