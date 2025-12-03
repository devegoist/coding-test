class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 > 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char peek = stack.peek();
                    if ((peek == '(' && c == ')')
                            || (peek == '{' && c == '}')
                            || (peek == '[' && c == ']')) {
                                stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}