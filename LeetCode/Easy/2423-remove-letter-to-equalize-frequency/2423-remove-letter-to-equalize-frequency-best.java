class Solution {
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : word.toCharArray()) {
            arr[c - 'a']--;
            if (frequencyEquals(arr)) {
                return true;
            }
            arr[c - 'a']++;
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