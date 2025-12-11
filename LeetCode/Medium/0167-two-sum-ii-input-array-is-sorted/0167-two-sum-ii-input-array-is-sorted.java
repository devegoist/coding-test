class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        int sum = -1001;
        while (sum != target) {
            sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        
        return new int[]{left + 1, right + 1};
    }
}