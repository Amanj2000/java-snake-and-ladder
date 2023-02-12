public class LadderSquare implements Square {
    private int start;
    private int end;

    LadderSquare(int start, int end) {
        this.start = start;
        this.end = end;

        assert(start < end);
        assert(start / 10 < end /10);
    }

    public int next() {
        return end;
    }

    @Override
    public String toString() {
        return "start: " + start + " " + "end: " + end;
    }
}
