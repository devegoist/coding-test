class Solution {
    int count = 0;
    boolean found = false;
    char[] chars = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        dfs(word, "");
        return count;
    }
    
    private void dfs(String word, String current) {
        System.out.println(current + " " + word.equals(current));
        if (word.equals(current)) {
            found = true;
            return;
        }
        
        if (current.length() == 5 || found) {
            return;
        }
        
        for (char c : chars) {
            count++;
            dfs(word, current + c);
            if (found) {
                return;
            }
        }
    }
}