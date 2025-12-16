class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        for (int i = 0; i < dungeons.length; i++) {
            boolean[] visited = new boolean[dungeons.length];
            visited[i] = true;
            int count = dfs(k, dungeons, i, visited);
            visited[i] = false;
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
    
    private int dfs(int k, int[][] dungeons, int dungeon, boolean[] visited) {
        int count = 0;
        if (k >= dungeons[dungeon][0]) {
            k -= dungeons[dungeon][1];
        } else {
            return count;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count = Math.max(count, dfs(k, dungeons, i, visited));
                visited[i] = false;
            }
        }
        
        return count + 1;
    }
}