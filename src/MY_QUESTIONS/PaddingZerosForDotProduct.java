package MY_QUESTIONS;

public class PaddingZerosForDotProduct {

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 4, -5};
        int[] b = {-1, -2, -3};
        System.out.println(new PaddingZerosForDotProduct().padZeros(a, b));
    }

    public int padZeros(int[] a, int[] b) {
        int[][] dpMatrix = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (i < j) dpMatrix[i][j] = Integer.MIN_VALUE;
                else {
                    if (j == 0) {
                        if (i == 0) dpMatrix[i][j] = a[0] * b[0];
                        else dpMatrix[i][j] = Math.max(a[i] * b[0], dpMatrix[i - 1][j]);
                    } else {
                        dpMatrix[i][j] = Math.max(dpMatrix[i - 1][j], dpMatrix[i - 1][j - 1] + a[i] * b[j]);
                    }
                }
            }
        }
        return dpMatrix[a.length - 1][b.length - 1];
    }
}
