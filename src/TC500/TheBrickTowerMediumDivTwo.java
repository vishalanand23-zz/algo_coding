package TC500;

public class TheBrickTowerMediumDivTwo {
    public int[] find(int[] heights) {
        int size = heights.length;
        boolean isUsed[] = new boolean[size];
        int positions[] = new int[size];
        int temp = heights[0];
        int posCounter = 0;
        for (int i = 0; i < size; i++) {
            if (heights[i] <= temp) {
                positions[posCounter] = i;
                isUsed[i] = true;
                posCounter++;
                temp = heights[i];
            }
        }
        while (posCounter < size) {
            int l = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (!isUsed[i] && heights[i] < l) {
                    l = heights[i];
                    pos = i;
                }
            }
            positions[posCounter] = pos;
            posCounter++;
            isUsed[pos] = true;
        }
        return positions;
    }


    public static void main(String[] args) {
        int[] inp = {5, 3, 4, 7, 1, 2, 6};
        int[] out = new TheBrickTowerMediumDivTwo().find(inp);
        for (int i : out) {
            System.out.println(i);
        }
    }
}
