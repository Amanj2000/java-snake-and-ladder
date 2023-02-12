import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    static Board configBoard(BufferedReader br) throws IOException {
        System.out.print("Enter board Size: ");
        int boardSize = Integer.parseInt(br.readLine());
        System.out.print("Enter no. of Snakes: ");
        int nSnakes = Integer.parseInt(br.readLine());
        System.out.print("Enter no. of Ladders: ");
        int nLadders = Integer.parseInt(br.readLine());

        return new Board(boardSize, nSnakes, nLadders);
    }

    static Player[] readPlayers(BufferedReader br, Board board) throws IOException {
        System.out.print("Enter no. of Players: ");
        int n = Integer.parseInt(br.readLine());

        Player[] players = new Player[n];
        for(int i=0; i<n; i++) {
            System.out.print("Enter name of Player" + (i+1) + ": ");
            String name = br.readLine();
            players[i] = new Player(name, board);
        }
        return players;
    }

    static void play(Player[] players) {
        int n = players.length;
        int playersFinished = 0;
        while(playersFinished < n) {
            for (int i = 0; i < n; i++) {
                if (!players[i].isReachedLastSquare()) {
                    System.out.printf("Player: %s \t Position: %d \t Roll: %d \t new Position: %d\n",
                            players[i].getName(), players[i].getPosition(), players[i].roll(), players[i].getPosition());
                    if (players[i].isReachedLastSquare()) {
                        playersFinished++;
                        System.out.println("Player " + players[i].getName() + " completed the game.");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Snakes and Ladders Game!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = configBoard(br);
        Player[] players = readPlayers(br, board);

        play(players);
    }
}
