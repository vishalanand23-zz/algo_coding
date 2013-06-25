package VERTLIM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases;
        String s = br.readLine();
        testCases = Integer.parseInt(s);
        for (int i = 0; i < testCases; i++) {
            s = br.readLine();
            int vertical = Integer.parseInt(s);
            s = br.readLine();
            solve(vertical, s);
        }
    }

    private static void solve(int vertical, String array) {
        int[] ver = new int[array.length()];
        int curVer = 0;
        ver[0] = 0;
        for (int i = 1; i < array.length(); i++) {
            char c = array.charAt(i);
            if (c == '(') {
                curVer--;
            } else if (c == ')') {
                curVer--;
            } else if (array.charAt(i - 1) != '(') {
                curVer += 2;
            }
            ver[i] = curVer;
        }
        printAll(vertical, array, ver);
    }

    private static void printAll(int vertical, String array, int[] ver) {
        char c;
        ArrayList<Character> s = new ArrayList<Character>();
        for (int i = 0; i < array.length(); i++) {
            c = array.charAt(i);
            if (c != '(' && c != ')' && c != '.' && ver[i] == vertical) {
                s.add(c);
            }
        }
        if (s.isEmpty()) System.out.println("Hallelujah!");
        else {
            Collections.sort(s);
            String ss = "";
            for (int j = 0; j < s.size(); j++) {
                ss += Character.toString(s.get(j));
            }
            System.out.println(ss);
        }
    }
}
