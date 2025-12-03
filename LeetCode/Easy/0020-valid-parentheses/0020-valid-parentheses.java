class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            
            if (p == ')' || p == '}' || p == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                Character peek = stack.peek();
                if (peek == null) {
                    return false;
                }

                if (peek == '(' && p == ')') {
                    stack.pop();
                } else if (peek == '{' && p == '}') {
                    stack.pop();
                } else if (peek == '[' && p == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(p);
            }
        }

        return stack.isEmpty() ? true : false;
    }
}