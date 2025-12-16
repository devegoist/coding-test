import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            boolean[] visited = new boolean[n + 1];
            int count = dfs(v1, visited, graph);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        
        return answer;
    }
    
    private int dfs(int node, boolean[] visited, List<Integer>[] graph) {
        visited[node] = true;
        int count = 1;
        
        for (int next: graph[node]) {
            if (!visited[next]) {
                count += dfs(next, visited, graph);
            }
        }
        
        return count;
    }
}