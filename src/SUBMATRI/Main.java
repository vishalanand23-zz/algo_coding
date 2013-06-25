package SUBMATRI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[][] matrix;
        try {
            String s = br.readLine();
            n = Integer.parseInt(s);
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                s = br.readLine();
                String s1[] = s.split(" ");
                int pp = 0;
                for (String s2 : s1) {
                    matrix[i][pp] = Integer.parseInt(s2);
                    pp++;
                }
            }
            int max = 0;
            int[][] dp = new int[n][n];
            for (int ii = 0; ii < n; ii++) {
                for (int jj = 0; jj < n; jj++) {
                    for (int kk = ii; kk < n; kk++) {
                        for (int ll = jj; ll < n; ll++) {
                            if (ii == kk && jj == ll) dp[kk][ll] = 1;
                            else if (ii == kk) {
                                if ((matrix[kk][ll - 1] >= matrix[kk][ll]) || dp[kk][ll - 1] == -1) {
                                    dp[kk][ll] = -1;
                                } else {
                                    dp[kk][ll] = (kk - ii + 1) * (ll - jj + 1);
                                }
                            } else if (jj == ll) {
                                if ((matrix[kk - 1][ll] >= matrix[kk][ll]) || dp[kk - 1][ll] == -1) {
                                    dp[kk][ll] = -1;
                                } else {
                                    dp[kk][ll] = (kk - ii + 1) * (ll - jj + 1);
                                }
                            } else {
                                if ((matrix[kk - 1][ll] >= matrix[kk][ll]) || (matrix[kk][ll - 1] >= matrix[kk][ll])
                                        || (dp[kk - 1][ll] == -1) || (dp[kk][ll - 1] == -1)) {
                                    dp[kk][ll] = -1;
                                } else {
                                    dp[kk][ll] = (kk - ii + 1) * (ll - jj + 1);
                                }
                            }
                            if (max < dp[kk][ll]) {
                                System.out.println(kk + " " + ll + " " + ii + " " + jj + " " + dp[kk][ll]);
                                max = dp[kk][ll];
                            }
                        }
                    }
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
