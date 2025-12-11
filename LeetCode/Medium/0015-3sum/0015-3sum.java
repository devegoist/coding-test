class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;  // 이전과 같은 값이면 건너뛰기
            }
            int a = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int b = nums[left];
                int c = nums[right];

                if (b + c > -a) {
                    right--;
                } else if (b + c < -a) {
                    left++;
                } else {
                    result.add(List.of(a, b, c));
                    right--;
                    left++;

                    while (left < right && nums[left] == b) {
                        left++;
                    }

                    while (left < right && nums[right] == c) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}