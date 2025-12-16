class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        // total = w * h;
        // h >= 3
        
        
        for (int h = 3; h * h <= total; h++) {
            if (total % h == 0) {
                int w = total / h;
                System.out.println(w + " " + h);
                
                int yH = h-2;
                int yW = w-2;
                
                if (h <= w && (yH * yW == yellow)) {
                    return new int[]{w, h};
                }
            }
        }
        
        return new int[]{};
    }
}