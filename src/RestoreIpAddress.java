public class Solution {
    private ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12)
            return new ArrayList<String>();
            
        dive(s, 0, new ArrayList<String>());
        return result;
    }
    
    private void dive(String s, int k, ArrayList<String> array) {
        if (array.size() == 4) {
            if (k < s.length()) // string is not consumed all
                return;
            StringBuffer buf = new StringBuffer();
            for (String token : array)
                buf.append(".").append(token);
            result.add(buf.substring(1));
        }
        
        for (int i = k; i < s.length(); i ++) {
            if (s.charAt(k) == '0' && i > k) // case of heading zero substring
                break;
            int v = 0;
            for (int j = k; j <= i; j ++)
                v = v * 10 + (int)(s.charAt(j) - '0');
            if (v > 255)
                break;
            array.add(s.substring(k, i + 1));
            dive(s, i + 1, array);
            array.remove(array.size() - 1);
        }
    }
}