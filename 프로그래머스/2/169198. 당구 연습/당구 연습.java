class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
    
        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];

            int minDistance = Integer.MAX_VALUE;
        
            boolean sameX = startX == ballX;
            boolean sameY = startY == ballY;
            
            if (!(sameY && ballX < startX)) {
                minDistance = Math.min(getDistance("L", m, n, startX, startY, ballX, ballY), minDistance);
            }
            
            if (!(sameY && ballX > startX)) {
                minDistance = Math.min(getDistance("R", m, n, startX, startY, ballX, ballY), minDistance);    
            }
            
            if (!(sameX && ballY > startY)) {
                minDistance = Math.min(getDistance("U", m, n, startX, startY, ballX, ballY), minDistance);
            }
            
            if (!(sameX && ballY < startY)) {
                minDistance = Math.min(getDistance("B", m, n, startX, startY, ballX, ballY), minDistance);    
            }
            
            answer[i] = minDistance;
        }

        return answer;
    }
    
    private int getDistance(String direction, int m, int n, int startX, int startY, int ballX, int ballY) {
        int mirrorX;
        int mirrorY;
        
        if ("L".equals(direction)) {
            mirrorY = ballY;
            mirrorX = -ballX;
        } else if ("R".equals(direction)) {
            mirrorY = ballY;
            mirrorX = (m * 2) - ballX;
        } else if ("U".equals(direction)) {
            mirrorY = (n * 2) - ballY;
            mirrorX = ballX;
        } else {
            mirrorY = -ballY;
            mirrorX = ballX;
        }
        
        int dx = mirrorX - startX;
        int dy = mirrorY - startY;
        return (dx*dx) + (dy*dy);
    }
}