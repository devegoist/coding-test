class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);    
                answer++;
            }
        }
        
        return answer;
    }
    // ... 0
    // ... 1
    
    
    
    private void dfs(int[][] computers, int current, boolean[] visited) {
        visited[current] = true;
        
        for (int i = 0; i < computers[current].length; i++) {
            if (i != current && !visited[i] && computers[current][i] == 1) {
                dfs(computers, i, visited);    
            }
        }
    }
}