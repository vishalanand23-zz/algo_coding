package SORTS;

public class MergeSort {

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

    private static int[] sort(int[] array, int i, int j) {
        if (i == j) {
            return new int[]{array[i]};
        } else {
            int pivot = (i + j) / 2;
            int[] a = sort(array, i, pivot);
            int[] b = sort(array, pivot + 1, j);
            return merge(a, b);
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] finalArray = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int i = 0;
        for (; i < finalArray.length; ) {
            if (a[aIndex] <= b[bIndex]) {
                finalArray[i] = a[aIndex];
                aIndex++;
                i++;
                if (aIndex == a.length) break;
            } else {
                finalArray[i] = b[bIndex];
                bIndex++;
                i++;
                if (bIndex == b.length) break;
            }
        }
        if (i == finalArray.length) return finalArray;
        if (aIndex == a.length) {
            while (i < finalArray.length) {
                finalArray[i] = b[bIndex];
                bIndex++;
                i++;
            }
        } else {
            while (i < finalArray.length) {
                finalArray[i] = a[aIndex];
                aIndex++;
                i++;
            }
        }
        return finalArray;
    }
}
