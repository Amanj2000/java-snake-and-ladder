public class Board {
    private int boardSize;
    private int nSquares;
    private int nSnakes;
    private int nLadders;

    private Square[] board;
    private boolean[] occupied;

    Board(int size, int nSnakes, int nLadders) {
        this.boardSize = size;
        this.nSnakes = nSnakes;
        this.nLadders = nLadders;

        this.nSquares = size * size;
        board = new Square[nSquares + 1];
        occupied = new boolean[nSquares + 1];
        generateBoard();
    }

    // generate a random number z between [x, y) such that z is not occupied
    private int random(int x, int y) {
        int z = x + (int)(Math.random() * (y - x));
        while(occupied[z]) z = x + (int)(Math.random() * (y - x));
        return z;
    }

    // generate two numbers start and end such that start < end and, start and end are not occupied
    private int[] generate() {
        int start = random(1, nSquares - boardSize + 1);
        int delta = boardSize + 1 - (start % boardSize);
        if(delta == boardSize + 1) delta = 1;
        int end = random(start + delta, nSquares);
        occupied[start] = occupied[end] = true;
        return new int[] { start, end };
    }

    private void generateBoard() {
        System.out.println("Snakes :- ");
        for(int i=0; i<nSnakes; i++) {
            int[] arr = generate();
            board[arr[1]] = new SnakeSquare(arr[1], arr[0]);
            System.out.println(board[arr[1]].toString());
        }

        System.out.println("Ladders :- ");
        for(int i=0; i<nLadders; i++) {
            int[] arr = generate();
            board[arr[0]] = new LadderSquare(arr[0], arr[1]);
            System.out.println(board[arr[0]].toString());
        }

        for(int i=0; i<nSquares; i++) {
            if(board[i] == null) {
                board[i]= new SimpleSquare(i);
            }
        }
    }

    public int getnSquares() {
        return nSquares;
    }

    public int next(int position) {
        return board[position].next();
    }
}