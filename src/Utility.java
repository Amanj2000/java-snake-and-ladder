public class Utility {
    /**
     * Generate a random number z between [x, y) such that z is free
     * @param x first integer
     * @param y second integer
     * @param occupied array that specify if a number is occupied or not
     * @return z
     */
    static private int random(int x, int y, boolean[] occupied) {
        int z = x + (int)(Math.random() * (y - x));
        while(occupied[z]) z = x + (int)(Math.random() * (y - x));
        return z;
    }

    /**
     * Generate two integer [start, end] such that start & end are free and start < end < boardSize^2
     * @param boardSize size of board
     * @param occupied array that specify if a number is occupied or not
     * @return [start, end]
     */
    static public int[] generateXY(int boardSize, boolean[] occupied) {
        int nSquares = boardSize * boardSize;

        int start = random(1, nSquares - boardSize + 1, occupied);

        int delta = boardSize + 1 - (start % boardSize);
        if(delta == boardSize + 1) delta = 1;
        int end = random(start + delta, nSquares, occupied);

        occupied[start] = occupied[end] = true;
        return new int[] { start, end };
    }
}
