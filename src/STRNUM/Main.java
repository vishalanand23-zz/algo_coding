package STRNUM;

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
            System.out.println("#" + (i + 1));
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        String s = br.readLine();
        int num = Integer.parseInt(s);
        Encoding[] encodings = new Encoding[num];
        for (int i = 0; i < num; i++) {
            s = br.readLine();
            String[] s1 = s.split(" ");
            encodings[i] = new Encoding(s1[0], s1[1]);
        }
        s = br.readLine();
        int testCase = Integer.parseInt(s);
        for (int i = 0; i < testCase; i++) {
            s = br.readLine();
            try {
                again(s, encodings);
            } catch (CustomException exception) {
                System.out.println(-1);
            }
        }
    }

    private static void again(String input, Encoding[] encodings) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            checkIfPresent(character, encodings);
            output = output + fetch(character, encodings);
        }
        System.out.println(output);
    }

    private static String fetch(char character, Encoding[] encodings) {
        int count = 0;
        char rotating = character;
        char[] ca = new char[encodings.length + 1];
        int caIndex = 0;
        while (true) {
            for (int i = 0; i < 10; i++) {
                if (Character.toString(rotating).equals(i + "")) {
                    return Character.toString(rotating);
                }
            }
            for (int i = 0; i < encodings.length; i++) {
                if (encodings[i].base == rotating) {
                    ca[caIndex] = rotating;
                    caIndex++;
                    rotating = encodings[i].result;
                    break;
                }
            }
            for (char c : ca) {
                if (c == rotating) {
                    return "0";
                }
            }
            if (count >= encodings.length) {
                throw new CustomException();
            }
            count++;
        }
    }

    private static void checkIfPresent(char character, Encoding[] encodings) {
        for (Encoding encoding : encodings) {
            if (encoding.base == character) return;
        }
        throw new CustomException();
    }

    private static class Encoding {
        char base;
        char result;

        private Encoding(String base, String result) {
            this.base = base.charAt(0);
            this.result = result.charAt(0);
        }
    }

    private static class CustomException extends RuntimeException {
    }
}
