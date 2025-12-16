import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        System.out.println("목적지: " + n + "," + m);
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                
                if (current[0] == n-1
                    && current[1] == m-1) {
                    return answer;
                }
                
                for (int j = 0; j < 4; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];
                    
                    if (nx >= 0 
                        && ny >= 0
                        && nx < n
                        && ny < m
                        && maps[nx][ny] == 1
                        && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return -1;
    }
}