class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, visited, i, j, dx, dy, 1));
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y, int[] dx, int[] dy, int count) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 
                && ny >= 0
                && nx < grid.length
                && ny < grid[0].length
                && !visited[nx][ny]
                && grid[nx][ny] == 1) {
                    count = dfs(grid, visited, nx, ny, dx, dy, count + 1);
            }
        }
        return count;
    }
}