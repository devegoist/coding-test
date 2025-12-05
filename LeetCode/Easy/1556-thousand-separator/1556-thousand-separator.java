class Solution {
    public String thousandSeparator(int n) {
        if (n < 1000) {
            return String.valueOf(n);
        }

        List<String> list = new ArrayList<>();
        while (n > 0) {
            int r = n % 1000;
            n = n / 1000;

            String value = String.valueOf(r);
            if (n > 0) {
                if (r < 10) {
                    value = "00" + value;
                } else if (r < 100) {
                    value = "0" + value;
                }
            }
            
            list.add(value);
        }

        String[] result = list.reversed().toArray(String[]::new);
        return String.join(".", result);
    }
}