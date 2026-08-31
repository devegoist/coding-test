import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        for (int i=0; i<progresses.length; i++) {
            days.add(((100 - progresses[i]) + (speeds[i] - 1) ) / speeds[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        int cnt = 1;
        int day = days.get(0);
        
        for (int i=1; i<days.size(); i++) {
            if (day >= days.get(i)) {
                cnt++;
            } else {
                result.add(cnt);
                day = days.get(i);
                cnt = 1;
            }
        }
        result.add(cnt);
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}