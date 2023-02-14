public class Die {
    private static final int DEFAULT_MIN_VALUE = 1;
    private static final int DEFAULT_MAX_VALUE = 6;
    private final int minValue;
    private final int maxValue;
    public Die() {
        this.minValue = DEFAULT_MIN_VALUE;
        this.maxValue = DEFAULT_MAX_VALUE;
    }
    public Die(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    public int rollDie() {
        return minValue + (int)(Math.random() * (maxValue - minValue + 1));
    }
}
