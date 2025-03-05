package practice;

public class CallTest {
    public static void main(String[] args) {
        CallTest test = new CallTest();
        test.callByValueTest();
    }

    void callByValueTest() {
        int i = 99;
        System.out.println("before : i = " + i);
        changeValue(i);
        System.out.println("after : i = " + i);
    }

    void changeValue(int j) {
        j = 88;
    }
}
