import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        int target = N / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            
            map.put(num, map.get(num) + 1);
        }
        
        System.out.println(map.size());
        
        return Math.min(map.size(), target);
    }
}