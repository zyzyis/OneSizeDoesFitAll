public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
            
        Stack<Character> stack = new Stack<Character>();
        boolean result = true;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {                
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }
                
                char top = stack.peek();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    result = false;
                    break;
                }
                
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (result && stack.isEmpty())
            return result;
        return false;               
    }
}