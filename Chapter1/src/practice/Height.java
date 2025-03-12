package practice;

public class Height implements Comparable {
    private int value;

    public Height(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }

    public int compareTo(Comparable x) {
        return value < ((Height)x).value ? -1 :
        value == ((Height)x).value ? 0 : 1;
    }
}
