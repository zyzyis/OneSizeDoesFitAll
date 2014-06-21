public class Solution {
    public int lengthOfLastWord(String s) {
        if (s != null){    
            String[] tokens = s.split(" ");
            if (tokens.length > 0)
                return tokens[tokens.length - 1].length();
        }
        return 0;
    }
}