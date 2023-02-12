import board.Board;

public class Player {
    private final String name;
    private final Board board;
    private int position;
    private boolean reachedLastSquare;

    Player(String name, Board board) {
        this.name = name;
        this.board = board;
        position = 0;
        reachedLastSquare = false;
    }

    public int roll() {
        // generate a random value between 1 and 6
        int value = (int)(Math.random() * 6 + 1);

        if(position + value < board.getnSquares()) {
            position += value;
            position = board.next(position);
        } else if(position + value == board.getnSquares()) {
            position += value;
            reachedLastSquare = true;
        }

        return value;
    }

    public String getName() {
        return name;
    }
    public int getPosition() { return position; }
    public boolean isReachedLastSquare() {
        return reachedLastSquare;
    }
}
