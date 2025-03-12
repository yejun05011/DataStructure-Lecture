package practice;

public abstract class Person {
    private String name;
    abstract public void writeOutput(); // 추상 메소드

    public Person() {
        name = "no name";
    }

    public Person(String name) {
        this.name = name;
    }

    // setter & getter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
