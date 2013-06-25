package MY_QUESTIONS;

import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in1 = "";
        String in2 = "";
        try {
            in1 = br.readLine();
            in2 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] a1 = in1.split(",");
        String[] a2 = in2.split(",");
        int temp = a2.length;
        if (a1.length > a2.length) {
            temp = a1.length;
        }
        long ans = 0;
        for (int i = 0; i < temp; i++) {
            long i1 = Long.parseLong(a1[i % a1.length]) * Long.parseLong(a2[i % a2.length]);
            ans = ans + i1;
        }
        System.out.println(ans);
    }
}