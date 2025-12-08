class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> poll = pq.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }

        return sb.toString();
    }
}