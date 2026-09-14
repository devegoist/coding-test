import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String player : completion) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String player: participant) {
            Integer count = map.get(player);
            if (count == null || count == 0) {
                return player;
            }
            map.put(player, count -= 1);
        }
        return "";
    }
}