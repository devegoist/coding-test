import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int count = 0;
        Set<String> used = new HashSet<>();
        
        Queue<Pair> queue = new  LinkedList<>();
        queue.offer(new Pair(begin, 0));
        
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            
            if (pair.getWord().equals(target)) {
                count = pair.getDepth();
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!used.contains(words[i]) && canConvert(pair.getWord(), words[i])) {
                    queue.offer(new Pair(words[i], pair.getDepth() + 1));
                    used.add(words[i]);
                }
            }
        }
        
        return count;
    }
    
    private boolean canConvert(String text, String word) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    
    public class Pair {
        private String word;
        private int depth;
        
        public Pair() {
        }
        
        public Pair(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
        
        public String getWord() {
            return word;
        }
        
        public int getDepth() {
            return depth;
        }
    }
}