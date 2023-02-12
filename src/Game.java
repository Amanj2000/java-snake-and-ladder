import board.Board;
import utility.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    static Board configBoard(BufferedReader br) {
        int boardSize = Utility.readInt(br, "Enter board Size: ");
        int nSnakes = Utility.readInt(br, "Enter no. of Snakes: ");
        int nLadders = Utility.readInt(br, "Enter no. of Ladders: ");
        return new Board(boardSize, nSnakes, nLadders);
    }

    static Player[] readPlayers(BufferedReader br, Board board) throws IOException {
        int n = Utility.readInt(br, "Enter no. of Players: ");
        Player[] players = new Player[n];
        for(int i=0; i<n; i++) {
            System.out.print("Enter name of Player" + (i+1) + ": ");
            players[i] = new Player(br.readLine(), board);
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
