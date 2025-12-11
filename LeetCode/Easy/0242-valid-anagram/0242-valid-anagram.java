class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        
        if (map1.size() != map2.size()) {
            return false;
        }
        
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            System.out.println(1);
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
}