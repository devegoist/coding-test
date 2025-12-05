class Solution {
    public String thousandSeparator(int n) {
        // 1234 -> 1.234
        // 12341234 -> 12.341.234

        // 12341234 % 1000 -> 12341...234
        // 12341 % 1000 -> 12...341
        // 12 % 1000 -> 0 ... 12

        if (n < 1000) {
            return String.valueOf(n);
        }

        List<String> list = new ArrayList<>();
        while (n > 0) {
            int r = n % 1000;
            n = n / 1000;
            list.add(String.valueOf(r));
        }

        String[] result = list.reversed().toArray(String[]::new);
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                if (result[i].length() < 3) {
                    result[i] = "0" + result[i];
                } else if (result[i].length() < 2) {
                    result[i] = "00" + result[i];
                }
            }
        }
        
        return String.join(".", result);
    }
}