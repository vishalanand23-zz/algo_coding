package MATPATH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases;
        String s = br.readLine();
        testCases = Integer.parseInt(s);
        for (int i = 0; i < testCases; i++) {
            s = br.readLine();
            int size = Integer.parseInt(s);
            int[][] originalMatrix = new int[size][size];
            for (int ii = 0; ii < size; ii++) {
                String[] s1 = br.readLine().split(" ");
                for (int jj = 0; jj < size; jj++) {
                    originalMatrix[ii][jj] = Integer.parseInt(s1[jj]);
                }
            }
            solve(originalMatrix);
        }
    }

    private static void solve(int[][] originalMatrix) {
        int n = originalMatrix.length;
        int[][] newMatrix = new int[n * 2][n * 2];
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                newMatrix[i][j] = max;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                newMatrix[i][j] = originalMatrix[i][j];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                newMatrix[2 * n - (i + 1)][2 * n - (j + 1)] = originalMatrix[i][j];
            }
        }
        for (int i = 0; i < 2 * n; i++) {
            if (i == 0) continue;
            if (i == n - 1) continue;
            if (i == n) continue;
            if (i == 2 * n - 1) continue;
            else newMatrix[i][i] = max;
        }
//        print(newMatrix);
        dp(newMatrix);
    }

    private static void dp(int[][] newMatrix) {
        int l = newMatrix.length;
        int[][] dpMatrix = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == l / 2 && j == l / 2) dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
                else if ((i == 0) && (j == 0)) dpMatrix[i][j] = newMatrix[i][j];
                else if (i == 0) {
                    if (dpMatrix[i][j - 1] == max || newMatrix[i][j] == max) {
                        dpMatrix[i][j] = max;
                    } else {
                        dpMatrix[i][j] = newMatrix[i][j] + dpMatrix[i][j - 1];
                    }
                } else if (j == 0) {
                    if (dpMatrix[i - 1][j] == max || newMatrix[i][j] == max) {
                        dpMatrix[i][j] = max;
                    } else {
                        dpMatrix[i][j] = newMatrix[i][j] + dpMatrix[i - 1][j];
                    }
                } else {
                    int min = dpMatrix[i - 1][j] > dpMatrix[i][j - 1] ? dpMatrix[i][j - 1] : dpMatrix[i - 1][j];
                    if (min == max || newMatrix[i][j] == max) dpMatrix[i][j] = max;
                    else dpMatrix[i][j] = min + newMatrix[i][j];
                }
            }
        }
//        print(dpMatrix);
        System.out.println(dpMatrix[l - 1][l - 1]);
    }

    private static void print(int[][] newMatrix) {
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
