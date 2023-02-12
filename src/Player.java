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

    public int roll(StringBuilder message) {
        int value = (int)(Math.random() * 6 + 1);

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
            reachedLastSquare = true;
        } else {
            message.append("need less steps than current roll to reach the end.");
        }

        return value;
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
    public boolean isReachedLastSquare() { return reachedLastSquare; }
}
