package practice;

public class Point {
    public double x;
    public double y;

    public void clear() {
        x = 0;
        y = 0;
    }

    public static void main(String[] args) {
        Point point1 = new Point();
        point1.x = 1;
        point1.y = 2;

        Point point2 = new Point();
        point2.x = 3;
        point2.y = 4;

        Point point3 = point1;  // 새로운 객체를 만든 것이 아닌 기존 객체의 주소만 복사한 것
    }
}
