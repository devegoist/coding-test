import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                System.out.println(current + " " + answer);
                if (current.equals(target)) {
                    return answer;
                }
                
                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && canChange(current, words[j])) {
                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    private boolean canChange(String current, String word) {
        int length = current.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            char c1 = current.charAt(i);
            char c2 = word.charAt(i);
            if (c1 != c2) {
                count += 1;    
            }
        }
        return count == 1 ? true : false;
    }
}