public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<>();
        if (L == null || L.length == 0)
            return result;
            
        HashMap<String, Integer> dict = new HashMap<>();
        for (String l : L) {
            if (!dict.containsKey(l))
                dict.put(l, 1);
            else
                dict.put(l, dict.get(l) + 1);
        }
        
        int len = L[0].length();
        for (int i = 0; i <= S.length() - len * L.length; i ++) {
            HashMap<String, Integer> count = (HashMap<String, Integer>)dict.clone();
            int remain = L.length;
            int j = i;
            while (remain > 0 && len + j <= S.length()) {
                String substr = S.substring(j, len + j);
                if (!count.containsKey(substr) || count.get(substr) == 0)
                    break;
                count.put(substr, count.get(substr) - 1);
                remain --;
                j = j + len;
            }
            
            if (remain == 0)
                result.add(i);
        }
        return result;
    }
}