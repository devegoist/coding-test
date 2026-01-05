class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c: s.toCharArray()) {
            if (!map1.containsKey(c)) {
                map1.put(c, 1);
            }
            map1.put(c, map1.get(c) + 1);
        }

        for (Character c: t.toCharArray()) {
            if (!map2.containsKey(c)) {
                map2.put(c, 1);
            }
            map2.put(c, map2.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry: map1.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (!(map2.containsKey(key) && val == map2.get(key))) {
                
                return false;
            }
        }

        return true;
    }
}