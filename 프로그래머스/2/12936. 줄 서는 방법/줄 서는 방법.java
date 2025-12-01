import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        for (int i = 0; i < n; i++) {
            long groupSize = factorial(n - 1 - i);
            int index = (int) ((k - 1) / groupSize);
            
            answer[i] = numbers.get(index);
            numbers.remove(index);
            
            k = (k - 1) % groupSize + 1;
        }
        
        return answer;
    }
    
    private long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}