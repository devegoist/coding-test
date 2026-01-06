class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;
        int direction = 0;

        for (int i = 0; i < m*n; i++) {
            result.add(matrix[x][y]);
            visited[x][y] = true;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                x = nx;
                y = ny;
                continue;
            } else {
                direction = (direction + 1) % 4;
                x += dx[direction];
                y += dy[direction];
            }
        }

        return result;
    }
}