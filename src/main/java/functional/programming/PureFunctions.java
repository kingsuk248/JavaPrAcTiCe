package functional.programming;

public class PureFunctions {
    public static void main(String[] args) {

    }

    /**
     * Example of a pure function
     * No side effects: i.e. does not modify state/variable outside the function
     * No state (external to function)
     */
    public int sum(int a, int b) {
        return a + b;
    }

    private int value = 0;

    /**
     * Example of not a pure function
     * State of 'value' is modified inside the function
     */
    public int addToValue(int x) {
        this.value += x;
        return this.value;
    }
}
