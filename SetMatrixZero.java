//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        List<int[]> zeroPositions = new ArrayList<>();
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    zeroPositions.add(new int[]{i, j});
//                }
//            }
//        }
//
//        for (int[] pos : zeroPositions) {
//            int row = pos[0];
//            int col = pos[1];
//
//            for (int j = 0; j < n; j++) {
//                matrix[row][j] = 0;
//            }
//
//            for (int i = 0; i < m; i++) {
//                matrix[i][col] = 0;
//            }
//        }
//
//    }
//}

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}