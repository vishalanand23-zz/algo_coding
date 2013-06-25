package TC250;

public class XorBoardDivTwo {
    public int theMax(String[] board) {
        int rows = board[0].length();
        int columns = board.length;
        int[][] mat = new int[rows][columns];
        initialize(board, mat);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int temp = 0;
                for (int k = 0; k < rows; k++) {
                    if (k == i) continue;
                    if (mat[k][j] == 0) {
                        temp++;
                    } else {
                        temp--;
                    }
                }

                for (int k = 0; k < columns; k++) {
                    if (k == j) continue;
                    if (mat[i][k] == 0) {
                        temp++;
                    } else {
                        temp--;
                    }
                }
                if (temp > max) max = temp;
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(mat[i][j]==1) max++;
            }
        }
        return max;
    }

    private void initialize(String[] board, int[][] mat) {
        for (int i = 0; i < board[0].length(); i++) {
            for (int j = 0; j < board.length; j++) {
                mat[i][j] = board[j].charAt(i) - '0';
            }
        }
    }
}
