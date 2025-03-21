package practice;

public class Student2 extends Person2 {
    public void output() {
        System.out.println("Student's object method");
    }
    public static void main(String[] args) {
        Person2 p = new Person2();
        p.output();

        p = new Student2();
        p.output();
    }
}
