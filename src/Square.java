public class Square {
    private final int start;
    private final int end;

    Square(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int next() {
        return end;
    }

    @Override
    public String toString() {
        return "start: " + start + " " + "end: " + end;
    }
}
