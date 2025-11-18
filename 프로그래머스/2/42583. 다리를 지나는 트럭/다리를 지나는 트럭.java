import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<int[]> bridge = new ArrayDeque<>();
        int time = 0;
        
        for (int truck : truck_weights) {
            time++;
            
            int[] firstTruck = bridge.peek();
            if (firstTruck != null && firstTruck[1] == time) {
                bridge.poll();
                weight += firstTruck[0];
            } 
            
            while (bridge.size() >= bridge_length
                  || weight < truck) {
                int[] peek = bridge.peek();
                if (peek[1] == time) {
                    bridge.poll();
                    weight += peek[0];
                } else {
                    time = peek[1];
                }
            }
            
            int due = bridge_length;
            int[] info = new int[2];
            info[0] = truck;
            info[1] = time + due;
            bridge.offer(info);
            weight -= truck;
        }
        
        return bridge.peekLast()[1];
    }
}