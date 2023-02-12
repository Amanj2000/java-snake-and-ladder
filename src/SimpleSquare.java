public class SimpleSquare implements Square {
    private int start;
    private int end;

    SimpleSquare(int position) {
        this.start = this.end = position;
    }

    public int next() {
        return this.end;
    }

    @Override
    public String toString() {
        return "start: " + start + " " + "end: " + end;
    }
}
