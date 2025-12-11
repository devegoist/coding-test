class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left != right) {
                int b = nums[left];
                int c = nums[right];

                if (b + c == -a) {
                    List<Integer> sum = new ArrayList<>();
                    sum.add(a);
                    sum.add(b);
                    sum.add(c);
                    result.add(sum);
                }

                if (b + c > -a) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}