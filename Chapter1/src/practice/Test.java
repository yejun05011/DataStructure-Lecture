package practice;

public class Test {
    public int value;

    void callByReferenceTest() {
        Test t = new Test();
        t.value = 99;

        System.out.println("before : i = " + t.value);

        changeValue(t);

        System.out.println("after : i = " + t.value);
    }

    void changeValue(Test j) {
        j.value = 88;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.callByReferenceTest();
    }
}
