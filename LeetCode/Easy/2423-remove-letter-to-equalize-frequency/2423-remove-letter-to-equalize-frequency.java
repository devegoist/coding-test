class Solution {
    public boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            int[] arr = new int[26];

            for (int j = 0; j < word.length(); j++) {
                if (i != j) {
                    arr[word.charAt(j) - 'a']++;
                }
            }

            if (frequencyEquals(arr)) {
                return true;
            }
        }

        return false;
    }

    private boolean frequencyEquals(int[] arr) {
        int target = 0;
        for (int num : arr) {
            if (num > 0) {
                target = num;
                break;
            }
        }

        for (int num : arr) {
            if (num > 0 && target != num) {
                return false;
            }
        }

        return true;
    }
}