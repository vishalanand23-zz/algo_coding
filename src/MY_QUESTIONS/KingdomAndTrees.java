package MY_QUESTIONS;

import java.util.Arrays;

public class KingdomAndTrees {

    public static void main(String[] args) {
        int[] array = {5, 2, 7, 66, 10};
        new KingdomAndTrees().minLevel(array);
    }

    public int minLevel(int[] heights) {
        int minIndex = 0;
        int minSpell = Integer.MAX_VALUE;
        int[] minArray = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < i + 1) continue;
            int[] tempArray = new int[heights.length];
            tempArray[i] = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < tempArray[j + 1]) {
                    tempArray[j] = heights[j];
                } else {
                    if (heights[j] > (heights[i] - i + j)) {
                        tempArray[j] = heights[i] - i + j;
                    } else {
                        tempArray[j] = heights[j];
                    }
                    int l = j;
                    while (tempArray[l] >= tempArray[l + 1]) {
                        tempArray[l + 1] = tempArray[l] + 1;
                        l++;
                    }
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] > tempArray[j - 1]) {
                    tempArray[j] = heights[j];
                } else {
                    if (heights[j] < (heights[i] - i + j)) {
                        tempArray[j] = heights[i] - i + j;
                    } else {
                        tempArray[j] = heights[j];
                    }
                    int l = j;
                    while (tempArray[l] <= tempArray[l - 1]) {
                        tempArray[l - 1] = tempArray[l] - 1;
                        l--;
                    }
                }
            }
            int tempSpell = 0;
            for (int k = 0; k < heights.length; k++) {
                tempSpell += Math.abs(heights[k] - tempArray[k]);
            }
            if (tempSpell < minSpell) {
                minIndex = i;
                minSpell = tempSpell;
                minArray = Arrays.copyOf(tempArray, tempArray.length);
            }
        }
        System.out.println("Index from which synchronization done: " + minIndex);
        System.out.println("Original trees");
        for (int i : heights) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("New tress");
        for (int i : minArray) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.print("Total spells required: " + minSpell);
        return minSpell;
    }
}
