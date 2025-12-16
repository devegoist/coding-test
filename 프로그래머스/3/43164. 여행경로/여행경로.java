import java.util.*;

class Solution {
    private boolean[] visited;
    private List<String> path;
    
    public String[] solution(String[][] tickets) {
        String[] result = {};
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        visited = new boolean[tickets.length];
        path = new ArrayList<>();
        path.add("ICN");
        
        dfs(tickets, "ICN");
        
        return path.toArray(String[]::new);
    }
    
    private boolean dfs(String[][] tickets, String current) {
        if (path.size() == tickets.length + 1) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && current.equals(tickets[i][0])) {
                System.out.println(current + " " + tickets[i][0] + " " + tickets[i][1]);
                visited[i] = true;
                String next = tickets[i][1];
                path.add(next);
                if (dfs(tickets, next)) {
                    return true;
                }
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
        
        return false;
    }
}