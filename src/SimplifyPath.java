public class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i ++) {
            if (tokens[i].length() == 0 || tokens[i].equals("."))
                continue;
            if (tokens[i].equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else
                stack.push(tokens[i]);
        }
        
        StringBuffer buf = new StringBuffer();
        while (!stack.empty())
            buf.insert(0, "/" + stack.pop());
        return buf.length() == 0 ? "/" : buf.toString();
    }
}