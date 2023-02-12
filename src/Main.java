import board.Board;
import utility.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Snakes and Ladders Game!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = configBoard(br);
        Player[] players = readPlayers(br, board);
        Game game = new Game(board, players);
        game.play();
    }
}
