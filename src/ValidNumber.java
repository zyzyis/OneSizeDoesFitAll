public class Solution {
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        int dot = -1;
        int e = -1;        
        boolean isNum = true;
        boolean isSign = false;
        s = s.trim();
        if (s.length() == 0)
            return false;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if ((c < '0' || c > '9') && (c != '.') && (c != 'e') && (c != 'E') && (c != '-') && (c != '+'))
                return false;
            
            if (c == '.') {
                if (dot != -1 || s.length() == 1 || e != -1)
                    return false;
                if (isSign && s.length() == 2)
                    return false;
                dot = i;
                isNum = false;
            } else if (c == 'e' || c == 'E') {
                if (e != -1 || i == 0 || i == s.length() - 1)
                    return false;
                if (dot == 0 && i == 1)
                    return false;
                if (isSign && i == 1)
                    return false;
                e = i;
                isNum = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && e != i - 1)
                    return false;
                if (i == s.length() - 1)
                    return false;
                    
                isNum = false;
                isSign = true;
            } else 
                isNum = true;           
        }
        return true;
    }
}