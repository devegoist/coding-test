class Solution {
    public boolean equalFrequency(String word) {

        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            
            Map<Character, Integer> map = new HashMap<>();
            for (char c : newWord.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            Set<Integer> set = new HashSet<>();
            map.forEach((k, v) -> {
                set.add(v);
            });
            
            if (set.size() == 1) {
                return true;
            }
        }
        return false;
    }
}