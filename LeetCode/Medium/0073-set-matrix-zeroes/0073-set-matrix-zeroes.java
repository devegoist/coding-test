class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> zeroList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        for (int[] cell : zeroList) {
            for (int i = 0; i < m; i++) {
                matrix[i][cell[1]] = 0;
            }

            for (int j = 0; j < n; j++) {
                matrix[cell[0]][j] = 0;
            }
        }        
    }
}