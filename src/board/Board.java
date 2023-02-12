package board;

import board.LadderSquare;
import board.SimpleSquare;
import board.SnakeSquare;
import board.Square;
import utility.Utility;

public class Board {
    private final int boardSize;
    private final int nSnakes;
    private final int nLadders;

    private final Square[] board;
    private final boolean[] occupied;

    public Board(int size, int nSnakes, int nLadders) {
        this.boardSize = size;
        this.nSnakes = nSnakes;
        this.nLadders = nLadders;

        int nSquares = size * size;
        board = new Square[nSquares + 1];
        occupied = new boolean[nSquares + 1];
        generateBoard();
    }

    private void generateBoard() {
        for(int i=0; i<nSnakes; i++) {
            int[] arr = Utility.generateXY(boardSize, occupied);
            board[arr[1]] = new SnakeSquare(arr[1], arr[0]);
        }

        for(int i=0; i<nLadders; i++) {
            int[] arr = Utility.generateXY(boardSize, occupied);
            board[arr[0]] = new LadderSquare(arr[0], arr[1]);
        }

        for(int i=0; i<board.length; i++) {
            if(board[i] == null) {
                board[i]= new SimpleSquare(i);
            }
        }
    }

    public int getnSquares() {
        return boardSize * boardSize;
    }

    public int next(int position) {
        return board[position].next();
    }
}