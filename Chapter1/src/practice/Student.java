package practice;

public class Student extends Person {
    private int id;

    public Student() {
        super();
        id = 0;
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
    }

    // 추상 메소드 구현
    public void writeOutput() {
        System.out.println("name : " + getName());
        System.out.println("Student number : " + id);
    }

    public void reset(String x, int newId) {
        setName(x);
        id = newId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
