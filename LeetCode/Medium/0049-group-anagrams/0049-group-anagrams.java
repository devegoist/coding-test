class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String ns = new String(c);
            List<String> list = map.getOrDefault(ns, new ArrayList<>());
            list.add(str);
            map.put(ns, list);
        }

        return new ArrayList<>(map.values());
    }
}