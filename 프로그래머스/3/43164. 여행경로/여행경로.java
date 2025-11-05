import java.util.*;

class Solution {
    private List<String> result = new ArrayList<>();
    private boolean[] used;
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        
        // 출발지별로 도착지를 알파벳 순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]); // 도착지 비교
            }
            return a[0].compareTo(b[0]); // 출발지 비교
        });
        
        result.add("ICN");
        
        tour(tickets, "ICN");
        
        return result.stream()
            .toArray(String[]::new);
    }
    
    private boolean tour(String[][] tickets, String country) {
        if (result.size() == tickets.length + 1) {
            return true;
        }
        
        // List<String[]> destinations = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (country.equals(tickets[i][0])
               && !used[i]) {
                used[i] = true;
                result.add(tickets[i][1]);

                if (tour(tickets, tickets[i][1])) {
                    return true;
                }
                
                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
        
        return false;
    }
}