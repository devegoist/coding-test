class Solution {
    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        int x = 0;
        int y = 0;
        int direction = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 1; i <= n*n; i++) {
            map[x][y] = i;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0)) {
                direction++;
                direction = direction % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }


        return map;
    }
}