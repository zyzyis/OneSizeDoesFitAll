public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
            
        ArrayList<String> tokens = new ArrayList<String>();
        int p0 = -1;
        int cur = 0;
        
        while (cur < s.length()) {
            if (isChar(s.charAt(cur))) {
                if (p0 == -1)
                    p0 = cur;            
            } else if (p0 != -1) {
                tokens.add(s.substring(p0, cur));
                p0 = -1;
            }
            cur ++;
        }
        
        if (p0 != -1)
            tokens.add(s.substring(p0, s.length()));
            
        StringBuilder builder = new StringBuilder();
        for (int i = tokens.size() - 1; i >= 0; i --) {
            builder.append(tokens.get(i));
            if (i != 0)
                builder.append(' ');
        }
        
        return builder.toString();            
    }
    
    private boolean isChar(char c) {
        return c != ' ' && c != '\t';
    }
}