import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        int j = 0;
        
        String answer = participant[participant.length - 1];
        
        while (j < completion.length) {
            String pName = participant[i];
            String cName = completion[j];
            
            if (pName.equals(cName)) {
                i++;
                j++;
            } else {
                answer = pName;
                break;
            }
        }
        
        return answer;
    }
}