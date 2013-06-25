package MY_QUESTIONS;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        boolean[] isUsed = new boolean[3];
//        new Permutation().printPerm(new char[]{'a', 'b', 'c'}, 3, "", isUsed);
        ArrayList<ArrayList<Character>> lists = new ArrayList<ArrayList<Character>>();
        ArrayList<Character> list1 = new ArrayList<Character>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        ArrayList<Character> list2 = new ArrayList<Character>();
        list2.add('d');
        list2.add('e');
        ArrayList<Character> list3 = new ArrayList<Character>();
        list3.add('f');
        list3.add('g');
        list3.add('h');
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        new Permutation().printVector(lists, 0, "");
    }

    public void printVector(ArrayList<ArrayList<Character>> lists, int index, String toPrint) {
        if (index == lists.size()) {
            System.out.println(toPrint);
            return;
        }
        ArrayList<Character> list = lists.get(index);
        for (Character aList : list) {
            printVector(lists, index + 1, toPrint + aList);
        }
    }

    public void printPerm(char[] charArray, int k, String toPrint, boolean[] used) {
        if (k == toPrint.length()) {
            System.out.println(toPrint);
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            printPerm(charArray, k, toPrint + charArray[i], used);
            used[i] = false;
        }
    }
}
