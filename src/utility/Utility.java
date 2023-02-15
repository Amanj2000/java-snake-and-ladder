package utility;

import java.io.BufferedReader;
import java.io.IOException;

public class Utility {
    // Generate a random number z between [x, y) such that z is free
    static private int random(int x, int y, boolean[] occupied) {
        int z = x + (int)(Math.random() * (y - x));
        while(occupied[z]) z = x + (int)(Math.random() * (y - x));
        return z;
    }

    // Generate two integer [start, end] such that start & end are free && start < end < boardSize^2
    static public int[] generateXY(int boardSize, boolean[] occupied) {
        int nSquares = boardSize * boardSize;

        int start = random(1, nSquares - boardSize + 1, occupied);

        int delta = boardSize + 1 - (start % boardSize);
        if(delta == boardSize + 1) delta = 1;
        int end = random(start + delta, nSquares, occupied);

        occupied[start] = occupied[end] = true;
        return new int[] { start, end };
    }

    static public int readInt(BufferedReader br, String message) {
        while(true) {
            try {
                System.out.print(message);
                return Integer.parseInt(br.readLine());
            } catch(NumberFormatException e) {
                System.out.println("Enter a valid number.");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}