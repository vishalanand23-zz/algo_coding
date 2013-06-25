package TC250;

public class FoxAndFlowerShopDivTwo {
    public int theMaxFlowers(String[] flowers, int r, int c) {
        int rowLength = flowers[0].length();
        int columnLength = flowers.length;
        boolean[][] boolFlowers = new boolean[columnLength][rowLength];
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                boolFlowers[i][j] = flowers[i].charAt(j) != '.';
            }
        }

        int max = 0;
        int temp = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (boolFlowers[i][j]) temp++;
            }
        }
        if (temp > max) max = temp;
        temp = 0;
        for (int i = r + 1; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (boolFlowers[i][j]) temp++;
            }

        }
        if (temp > max) max = temp;
        temp = 0;
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < c; j++) {
                if (boolFlowers[i][j]) temp++;
            }
        }
        if (temp > max) max = temp;
        temp = 0;
        for (int i = 0; i < columnLength; i++) {
            for (int j = c+1; j < rowLength; j++) {
                if (boolFlowers[i][j]) temp++;
            }
        }
        if (temp > max) max = temp;
        return max;
    }
}
