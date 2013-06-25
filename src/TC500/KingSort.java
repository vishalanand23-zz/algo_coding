package TC500;

public class KingSort {

    public String[] getSortedList(String[] kings) {
        for (int i = 0; i < kings.length; i++) {
            int index = i;
            for (int j = i + 1; j < kings.length; j++) {
                if (!compare(kings[index], kings[j])) index = j;
            }
            String temp = kings[index];
            kings [index] = kings[i];
            kings[i] = temp;
        }
        return kings;
    }

    private boolean compare(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        int diff = arr1[0].compareTo(arr2[0]);
        if (diff > 0) return false;
        else if (diff < 0) return true;
        else return romanToInteger(arr1[1]) < romanToInteger(arr2[1]);
    }

    private int romanToInteger(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'L') {
                if (i > 0) num += 30;
                else num = 50;
            } else if (c == 'X') {
                if (i == 0) num = 10;
                else {
                    char d = arr[i - 1];
                    if (d == 'I') num += 8;
                    else num += 10;
                }
            } else if (c == 'V') {
                if (i == 0) num = 5;
                else {
                    char d = arr[i - 1];
                    if (d == 'I') num += 3;
                    else num += 5;
                }
            } else if (c == 'I') num += 1;
        }
        return num;
    }
}
