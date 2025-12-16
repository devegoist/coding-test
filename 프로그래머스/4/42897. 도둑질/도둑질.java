class Solution {
    public int solution(int[] money) {
        int prev0 = 0;
        int prev1 = money[0];
        
        for (int i = 1; i < money.length-1; i++) {
            int curr0 = Math.max(prev0, prev1);
            int curr1 = prev0 + money[i];
            prev0 = curr0;
            prev1 = curr1;
        }
        
        int max1 = Math.max(prev0, prev1);
        
        prev0 = 0;
        prev1 = money[1];
        for (int i = 2; i < money.length; i++) {
            int curr0 = Math.max(prev0, prev1);
            int curr1 = prev0 + money[i];
            prev0 = curr0;
            prev1 = curr1;
        }
        
        int result = Math.max(
            max1,
            Math.max(prev0, prev1)
        );
        
        return result;
    }
}