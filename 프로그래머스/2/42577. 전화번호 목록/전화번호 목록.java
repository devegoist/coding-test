import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> bookSet = new HashSet<>();
        for (String phone : phone_book) {
            bookSet.add(phone);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (prefix.equals(phone)) continue;
                if (bookSet.contains(prefix)) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}