class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfs(grid, visited, i, j, dx, dy);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, boolean [][] visited, int x, int y, int[] dx, int[] dy) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0
                && ny >= 0
                && nx < grid.length
                && ny < grid[0].length
                && !visited[nx][ny]
                && grid[nx][ny] == '1') {
                    dfs(grid, visited, nx, ny, dx, dy);
            }
        }
    }
}