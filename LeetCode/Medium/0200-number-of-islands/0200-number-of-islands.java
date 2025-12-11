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
                if (visited[i][j] == false && grid[i][j] == '1') {
                    result++;
                    bfs(grid, visited, i, j, dx, dy);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, boolean[][] visited, int startX, int startY, int[] dx, int[] dy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int x = loc[0];
            int y = loc[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 
                    && ny >= 0 
                    && nx < grid.length 
                    && ny < grid[0].length
                    && !visited[nx][ny]
                    && grid[nx][ny] == '1') {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}