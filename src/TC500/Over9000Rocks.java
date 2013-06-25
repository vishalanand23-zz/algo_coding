package TC500;

import java.util.Arrays;
import java.util.Comparator;

public class Over9000Rocks {

    public static void main(String[] args) {
        int[] lower = {729521, 788949, 148221, 3423, 231974, 569820, 332636};
        int[] upper = {951408, 974213, 708093, 720084, 459786, 620622, 497059};
        int[] lower1 = {9001, 9001, 9001};
        int[] upper1 = {9001, 9001, 9001};
        System.out.println(new Over9000Rocks().countPossibilities(lower1, upper1));
    }

    public int countPossibilities(int[] lowerBound, int[] upperBound) {
        int num = 0;
        int size = (int) (Math.pow(2, lowerBound.length));
        int lo[] = new int[size];
        int up[] = new int[size];
        for (int i = 0; i < size; i++) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    int l = j + lowerBound.length - binary.length();
                    lo[i] += lowerBound[l];
                    up[i] += upperBound[l];
                }
            }
        }
        Struc[] array1 = new Struc[2 * lo.length];
        int index = 0;
        for (int i = 0; i < up.length; i++) {
            if (up[i] >= 9001) {
                array1[index] = new Struc(lo[i], true);
                array1[index + 1] = new Struc(up[i], false);
                index += 2;
            }
        }
        Struc[] array = new Struc[index];
        for (int i = 0; i < index; i++) {
            array[i] = array1[i];
        }
        Arrays.sort(array, new Comparator<Struc>() {
            public int compare(Struc struc, Struc struc1) {
                if(struc.value == struc1.value){
                    if(struc.isLow && !struc1.isLow) return -1;
                    if(!struc.isLow && struc1.isLow) return 1;
                }
                return (struc.value - struc1.value);
            }
        });
        int ii = 0;
        if (array.length == 0) return 0;
        while (array[ii].value < 9001) {
            ii++;
            if (ii == array.length) return 0;
        }
        int temp;
        int diff = 0;
        if (ii > 0) {
            temp = 9001;
            diff = ii;
        } else temp = array[0].value;
        for (int i = ii; i < array.length; i++) {
            if (array[i].isLow) {
                diff++;
            } else {
                diff--;
            }
            if (diff == 0) {
                num += (array[i].value - temp + 1);
                if (i == array.length - 1) break;
                else temp = array[i + 1].value;
            }
        }
        return num;
    }

    private class Struc {
        public final int value;
        public final boolean isLow;

        public Struc(int i, boolean b) {

            this.value = i;
            this.isLow = b;
        }
    }
}
