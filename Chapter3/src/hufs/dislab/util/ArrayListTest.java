package hufs.dislab.util;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(5);

        list.add(1);
        list.add(1, 2);
        list.add(3);
        list.add(4);
        list.add(2, 5);
        // list.add(6);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.remove(new Integer(3));
        System.out.println(list);
    }
}
