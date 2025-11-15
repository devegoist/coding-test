import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        Map<String, Object> res = new HashMap<>();
        res.put("playTime", 0);
        res.put("title", "(None)");
        
        // C#, D#, F#, G#, A#
        // H, I, J, K, L 로 변환해서 생각
        
        m = m.replaceAll("C#", "H");
        m = m.replaceAll("D#", "I");
        m = m.replaceAll("F#", "J");
        m = m.replaceAll("G#", "K");
        m = m.replaceAll("A#", "L");
        m = m.replaceAll("B#", "M");
        
        for (String musicInfo: musicinfos) {
            String[] music = musicInfo.split(",");
            String start = music[0];
            String end = music[1];
            String title = music[2];
            String code = music[3];
            
            code = code.replaceAll("C#", "H");
            code = code.replaceAll("D#", "I");
            code = code.replaceAll("F#", "J");
            code = code.replaceAll("G#", "K");
            code = code.replaceAll("A#", "L");
            code = code.replaceAll("B#", "M");
            
            int length = code.length();
            
            String[] startTime = start.split(":");
            String[] endTime = end.split(":");
            
            Integer startHour = Integer.parseInt(startTime[0]);
            Integer startMinute = Integer.parseInt(startTime[1]);
            
            Integer endHour = Integer.parseInt(endTime[0]);
            Integer endMinute = Integer.parseInt(endTime[1]);
            
            int playMin = 0;
            if (endMinute <= startMinute) {
                playMin = ((endHour - startHour) * 60) - (startMinute - endMinute);
            } else {
                playMin = ((endHour - startHour) * 60) + (endMinute - startMinute);
            }
            
            String playedCode = playedCodes(playMin, code);
            
            if (playedCode.contains(m)) {
                Integer basePlayTime = (Integer) res.get("playTime");
                if (playMin > basePlayTime) {
                    res.put("playTime", playMin);
                    res.put("title", title);
                }
            }
        }
        
        return (String) res.get("title");
    }
    
    private String playedCodes(int playMinute, String baseCode) {
        int baseCodeLength = baseCode.length();
        int repeat = playMinute / baseCodeLength;
        int rest = playMinute % baseCodeLength;
        // int totalCodeLength = repeat + rest;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(baseCode);
        }
        
        for (int i = 0; i < rest; i++) {
            sb.append(baseCode.charAt(i));
        }
        return sb.toString();
    }
}