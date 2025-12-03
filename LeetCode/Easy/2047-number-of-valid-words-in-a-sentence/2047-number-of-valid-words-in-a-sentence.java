class Solution {
    public int countValidWords(String sentence) {
        String[] sen = sentence.split(" ");

        int result = 0;
        for (String s : sen) {
            if (!"".equals(s) && isValid(s)) {
                result++;
            }
        }

        return result;
    }

    private boolean isValid(String sentence) {
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('0' <= c && c <= '9') {
                return false;
            }

            if (i < chars.length - 1) {
                if (c == '!' || c == '.' || c == ',') {
                    return false;
                }
            }

            if (i == 0 || i == chars.length - 1) {
                if (c == '-') {
                    return false;
                }
            }
        }

        String[] s = sentence.split("-");
        if (s.length > 2) {
            return false;
        }

        int idx = sentence.indexOf("-");
        System.out.println(idx);
        if (idx > 0 && !('a' <= sentence.charAt(idx - 1) && sentence.charAt(idx - 1) <= 'z')) {
            return false;
        }

        if (idx > 0 && !('a' <= sentence.charAt(idx + 1) && sentence.charAt(idx + 1) <= 'z')) {
            return false;
        }

        return true;
    }
}