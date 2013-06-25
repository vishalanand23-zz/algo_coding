package LFSM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases;
        String s = br.readLine();
        testCases = Integer.parseInt(s);
        for (int i = 0; i < testCases; i++) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[] tree = new int[n + 1];
        s = br.readLine();
        String[] s1 = s.split(" ");
        int j = 1;
        for (String s2 : s1) {
            tree[j] = Integer.parseInt(s2);
            j++;
        }
        int[] sumLength = new int[n + 1];
        int[] maxLength = new int[n + 1];
        dfs(tree, sumLength, maxLength, 1);
        printMax(sumLength);
    }

    private static void printMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length/2; i++) {
            if (array[i] > max) max = array[i];
        }
        System.out.println(max);
    }

    private static void dfs(int[] tree, int[] sumLength, int[] maxLength, int i) {
        if (2 * i < tree.length) {
            dfs(tree, sumLength, maxLength, 2 * i);
            dfs(tree, sumLength, maxLength, 2 * i + 1);
            sumLength[i] = maxLength[2 * i] + maxLength[2 * i + 1] + tree[i];
            int maxChild = maxLength[2 * i] > maxLength[2 * i + 1] ? maxLength[2 * i] : maxLength[2 * i + 1];
            maxLength[i] = maxChild + tree[i];
        } else {
            sumLength[i] = tree[i];
            maxLength[i] = tree[i];
        }
    }
}
