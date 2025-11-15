import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        
        // 제일 작은 수 * 제일 큰 수
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n = A.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - 1 - i];
        }
        
        return answer;
    }
}