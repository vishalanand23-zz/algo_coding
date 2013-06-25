package SORTS;

public class QuickSort {

    public static void main(String[] args) {
        int size = 10000;
        int[] array = new int[size];
        long total = 0;
        int num = 10000;
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

    private static void sort(int[] array, int i, int j) {
        if (i >= j) return;
        int tempIndex = i;
        for (int k = i + 1; k <= j; k++) {
            if (array[k] < array[tempIndex]) {
                if (tempIndex == k - 1) {
                    int temp = array[tempIndex];
                    array[tempIndex] = array[k];
                    array[k] = temp;
                } else {
                    int temp = array[tempIndex];
                    array[tempIndex] = array[k];
                    array[k] = array[tempIndex + 1];
                    array[tempIndex + 1] = temp;
                }
                tempIndex++;
            }
        }
        sort(array, i, tempIndex - 1);
        sort(array, tempIndex + 1, j);
    }
}
