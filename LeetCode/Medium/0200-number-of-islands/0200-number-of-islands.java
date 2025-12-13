class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, visited, i, j, dx, dy);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int m, int n, int[] dx, int[] dy) {
        visited[m][n] = true;

        for (int i = 0; i < 4; i++) {
            int nx = m + dx[i];
            int ny = n + dy[i];

            if (nx >= 0 
                && ny >= 0 
                && nx < grid.length 
                && ny < grid[0].length
                && grid[nx][ny] == '1'
                && !visited[nx][ny]) {
                dfs(grid, visited, nx, ny, dx, dy);
            }           
        }
    }
}