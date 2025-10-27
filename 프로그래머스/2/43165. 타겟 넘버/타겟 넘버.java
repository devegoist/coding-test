class Solution {
    private int[] numbers;
    private int target;
    private int[][] result;
    private int count;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.result = new int[numbers.length][numbers.length];
        
        dfs(0, 0);
        
        return count;
    }
    
    private void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}