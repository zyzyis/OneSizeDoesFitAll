public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> istack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ')' && (
                !stack.isEmpty() && stack.peek() == '(')) {
                stack.pop();
                istack.pop();
            } else {
                stack.push(s.charAt(i));
                istack.push(i + 1); // starting from 1
            }
        }
        
        int max = 0, pre = 0;
        for (int i = 0; i < istack.size(); i ++) {
            int cur = istack.get(i);
            max = Math.max(max, cur - pre - 1);
            pre = cur;
        }
        return Math.max(max, pre == 0 ? s.length() : s.length() - pre);
    }
}