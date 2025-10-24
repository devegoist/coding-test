import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 1; i > 0; i--) {
            int[] line = triangle[i];
            int[] parent = triangle[i - 1];
            
            for (int j = 0; j < line.length - 1; j++) {
                int left = line[j];
                int right = line[j + 1];
                
                parent[j] += Math.max(left, right);
            }
        }
        
        return triangle[0][0];
    }
}