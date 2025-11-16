import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 7, 3, 9
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int days = (100 - progress) / speeds[i];
            if ((100 - progress) % speeds[i] > 0) {
                days++;
            }
            queue.offer(days);
        }
        
        List<Integer> result = new ArrayList<>();
        int current = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int peek = queue.peek();
            if (peek <= current) {
                queue.poll();
                count++;
            } else {
                result.add(count);
                current = queue.poll();
                count = 1;
            }
            
            if (queue.isEmpty()) {
                result.add(count);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}