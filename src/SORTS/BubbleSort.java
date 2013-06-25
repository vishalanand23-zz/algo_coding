package SORTS;

public class BubbleSort {
    public static void main(String[] args) {
        int size = 10000;
        int[] array = new int[size];
        long total = 0;
        int num = 10;
        for (int l = 0; l < num; l++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) Math.ceil(Math.random() * size);
            }
            long pre = System.nanoTime();
            sort(array, 0, array.length - 1);
            long post = System.nanoTime();
            total += (post - pre);
        }
        System.out.println(total / num / 1000000.0 + " millis for an array of size: " + size);
    }

    private static void sort(int[] array, int start, int end) {
        if (start == end) return;
        for (int i = end; i > start; i--) {
            for (int j = start + 1; j <= i; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
