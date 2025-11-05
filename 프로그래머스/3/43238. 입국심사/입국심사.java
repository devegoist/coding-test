import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for (int time: times) {
            max = Math.max(max, time);
        }
        
        long left = 1;
        long right = max * n;
        
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long total = 0;
            for (int time: times) {
                total += mid / time;
            }
            
            if (total < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}