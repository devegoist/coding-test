import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] node : edge) {
            if (!graph.containsKey(node[0])) {
                graph.put(node[0], new ArrayList<>());
            }
            graph.get(node[0]).add(node[1]);
            
            if (!graph.containsKey(node[1])) {
                graph.put(node[1], new ArrayList<>());
            }
            graph.get(node[1]).add(node[0]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1});
        visited[1] = true;

        int lastDistance = 0;
        Map<Integer, Integer> distanceCount = new HashMap<>();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int distance = current[0];
            int node = current[1];
            
            lastDistance = distance;
            distanceCount.putIfAbsent(distance, 0);
            distanceCount.put(distance, distanceCount.get(distance) + 1);
            
            for (int next: graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{distance+1, next});
                }
            }
        }
        return distanceCount.get(lastDistance);
    }
}