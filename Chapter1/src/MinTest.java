public class MinTest {
    public static void main(String[] args) {
        int a = 3;
        int b = 7;
        System.out.println(min(a, b));
    }

    protected static int min(int x, int y) {
        return x > y ? y : x;
    }
}
