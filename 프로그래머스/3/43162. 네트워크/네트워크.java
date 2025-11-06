import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 너비우선탐색으로 풀어보자
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    if (!graph.containsKey(i)) {
                        graph.put(i, new ArrayList<>());
                    }
                    graph.get(i).add(j);    
                }
            }
        }
        boolean[] visited = new boolean[n+1];
        
        // 0, [0, 1]
        // 1, [1, 0]
        // 2, [2]
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                
                Queue<Integer> queue = new LinkedList<>();
                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int computer = queue.poll();
                    for (int linked : graph.get(computer)) {
                        if (!visited[linked]) {
                            visited[linked] = true;
                            queue.add(linked);
                        }
                    }
                }  
            }  
        }
        
        return count;
    }
}