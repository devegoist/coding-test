import java.util.*;

class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        
        return bfs(maps, queue, visited);
    }
    
    private int bfs(int[][] maps, Queue<int[]> queue, boolean[][] visited) {
        int n = maps.length;        // 행의 개수
        int m = maps[0].length;     // 열의 개수
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < n && nx >= 0 && ny < m && ny >= 0
                    && maps[nx][ny] == 1
                    && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1;
    }
}