import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth: clothes) {
            if (!map.containsKey(cloth[1])) {
                map.put(cloth[1], 0);
            }
            
            map.put(cloth[1], map.get(cloth[1]) + 1);
        }
        
        
        int answer = 1;
        
        for (Integer value: map.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}