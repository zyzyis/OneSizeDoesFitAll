public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.equals("") || T.equals(""))
            return "";
        HashMap<Character, Integer> tmap = new HashMap<>(128)
        HashMap<Character, Integer> smap = new HashMap<>(128);
        for (int i = 0; i < T.length(); i ++) {
            char c = T.charAt(i);
            if (tmap.containsKey(c))
                tmap.put(c, tmap.get(c) + 1);
            else
                tmap.put(c, 1);
        }

        int minLeft = 0, minRight = 0, minLen = Integer.MAX_VALUE;
        int matched = 0;
        for (int i = 0, left = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            if (smap.containsKey(c))
                smap.put(c, smap.get(c) + 1);
            else
                smap.put(c, 1);
                
            if (tmap.containsKey(c) && smap.get(c).equals(tmap.get(c)))
                matched ++;
            if (matched == tmap.size()) {
                char leftc = S.charAt(left);
                while (!tmap.containsKey(leftc) || smap.get(leftc) > tmap.get(leftc)) {
                    smap.put(leftc, smap.get(leftc) - 1);
                    left ++;
                    leftc = S.charAt(left);
                }
                
                if (i - left < minLen) {
                    minLen = i - left;
                    minLeft = left;
                    minRight = i;
                }
            }
        }
        
        if (minLen == Integer.MAX_VALUE)
            return "";
        return S.substring(minLeft, minRight + 1);
    }
}