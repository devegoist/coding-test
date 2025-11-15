class Solution {
    private int count = 0;
    private int zero = 0;
    
    public int[] solution(String s) {
        while (true) {
            if ("1".equals(s)) {
                break;
            }
            
            s = convert(s);
        }
        
        int[] answer = {count, zero};
        return answer;
    }
    
    private String convert(String s) {
        count++;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            }
        }
        
        // 0 제거
        s = s.replaceAll("0", "");
        
        // 길이 측정
        int length = s.length();
        
        // 길이를 2진법 표현 
        return Integer.toBinaryString(length);
    }
}