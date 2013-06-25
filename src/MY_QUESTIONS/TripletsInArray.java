package MY_QUESTIONS;

import java.util.Arrays;
import java.util.Comparator;

public class TripletsInArray {

    public static class NewPoint {
        final int j;
        final int k;
        final int sum;

        public NewPoint(int j, int k, int sum) {
            this.j = j;
            this.k = k;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        int[] array = {-12, -7, -4, 0, 3, 5, 9, 10, 15, 16};
        findTriplets(array);
        System.out.println();
        findTripletsEfficiently(array);
    }

    private static void findTripletsEfficiently(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int init = 0;
            int end = array.length - 1;
            while (init < end) {
                if (init == i) {
                    init++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                if (array[init] + array[end] == array[i]) {
                    System.out.println(init + " " + end + " " + i);
                    init++;
                    end--;
                } else if (array[init] + array[end] > array[i]) {
                    end--;
                } else {
                    init++;
                }
            }
        }
    }

    private static void findTriplets(int[] array) {
        int len = array.length;
        NewPoint[] bigArray = new NewPoint[(len * (len - 1)) / 2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                bigArray[index] = new NewPoint(i, j, array[i] + array[j]);
                index++;
            }
        }
        Arrays.sort(bigArray, new Comparator<NewPoint>() {
            public int compare(NewPoint newPoint, NewPoint newPoint1) {
                return newPoint.sum - newPoint1.sum;
            }
        });
        for (int i = 0; i < len; i++) {
            binarySearchAndPrint(array[i], bigArray, i, 0, (len * (len - 1)) / 2);
        }
    }

    private static void binarySearchAndPrint(int num, NewPoint[] array, int i, int beg, int end) {
        if (beg >= end) return;
        int mid = (beg + end) / 2;
        if (array[mid].sum == num) {
            checkCandidateAndPrint(array[mid], i);
            int mid2 = mid + 1;
            while (array[mid2].sum == num) {
                checkCandidateAndPrint(array[mid2], i);
                mid2++;
            }
            mid2 = mid - 1;
            while (array[mid2].sum == num) {
                checkCandidateAndPrint(array[mid2], i);
                mid2--;
            }
        } else if (array[mid].sum < num) {
            binarySearchAndPrint(num, array, i, mid + 1, end);
        } else {
            binarySearchAndPrint(num, array, i, beg, mid - 1);
        }
    }

    private static void checkCandidateAndPrint(NewPoint newPoint, int i) {
        if ((newPoint.j < newPoint.k) && (i != newPoint.j) && (i != newPoint.k)) {
            System.out.println(newPoint.k + " " + newPoint.j + " " + i);
        }
    }
}
