class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int size = strs.length;

        Arrays.sort(strs, (a, b) -> a.compareTo(b));

        int minLength = strs[0].length();

        int index = 0;
        while (true) {
            if (index == minLength) break;

            char first = strs[0].charAt(index);
            char last = strs[size - 1].charAt(index);

            if (first == last) {
                sb.append(first);
                index++;
            } else {
                break;
            }
        }

        return sb.toString();
    }
}