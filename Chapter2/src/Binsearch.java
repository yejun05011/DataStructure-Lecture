public class Binsearch {
    public static int binsearch(int[] a, int key, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (key == a[mid]) return mid;
            else if (key < a[mid]) return binsearch(a, key, left, mid - 1);
            else return binsearch(a, key, mid + 1, right);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 9, 11, 13};
        int key = 7;
        int index = binsearch(arr, key, 0, arr.length - 1);
        System.out.println(index);
    }
}
