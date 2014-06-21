public class Solution {
    public boolean isMatch(String s, String p) {
        int pIndex = 0, sIndex = 0;
        int cp = -1, cs = -1;
        while (sIndex < s.length()) {
            char c = pIndex < p.length() ? p.charAt(pIndex) : 0;
            if (s.charAt(sIndex) == c || c == '?') { 
                // single char matches
                pIndex ++; 
                sIndex ++;
            } else if (c == '*') { 
                // star match, remember the star position
                cp = pIndex ++;
                cs = sIndex;
            } else if (cs != -1) { 
                // match failed, restore the star position and try again
                pIndex = cp + 1;
                sIndex = cs ++;
            } else
                return false;
        }
        
        // dedup trailing stars
        while (pIndex < p.length() && p.charAt(pIndex) == '*')
            pIndex ++;
            
        if (sIndex == s.length() && pIndex == p.length())
            return true;
        if (pIndex == p.length() && pIndex > 0 && p.charAt(pIndex - 1) == '*')
            return true;
        return false;
    }
}