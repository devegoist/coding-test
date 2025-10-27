class Solution {
    public int solution(int[] money) {
        // money가 가장 큰걸 찾아야된다 싶지만... 결국 가장 큰걸 고르고 나머지가 너무 적으면 안됨..
        // 결국 이것도 동적계획법... 작은 범위의 값을 구하고 더했을때 진짜 큰 경우를 찾아야함
        
        int case1 = route(money, 0, money.length - 2);
        int case2 = route(money, 1, money.length - 1);
        
        System.out.println("case1: " + case1);
        System.out.println("case2: " + case2);
        
        return Math.max(case1, case2);
    }
    
    private int route(int[] money, int start, int end) {
        if (start == end) {
            return money[start];
        }
        
        int length = end - start + 1;
        int[] dp = new int[end - start + 1];
        
        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);
        
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(
                dp[i-1],
                dp[i-2] + money[start + i]
            );
        }
        
        return dp[length - 1];
    }
}