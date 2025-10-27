class Solution {
    private int[][] computers;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int computer) {
        visited[computer] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[computer][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
        
    }
}