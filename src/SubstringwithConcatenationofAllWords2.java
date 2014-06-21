public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<>();
        if (L == null || L.length == 0)
            return result;

        HashMap<String, Integer> index = new HashMap<>();
        int[] counts = new int[L.length];
        int size = 0;
        for (String l : L) {
            if (!index.containsKey(l)) {
                index.put(l, size);
                counts[size ++] = 1;
            } else
                counts[index.get(l)] ++; 
        }
        
        int[] m = new int[S.length()];
        int len = L[0].length();
        for (int i = 0; i + len <= S.length(); i ++) {
            String substr = S.substring(i, i + len);
            m[i] = index.containsKey(substr) ? index.get(substr) : -1;
        }
        
        for (int i = 0; i <= S.length() - len * L.length; i ++) {
            int[] tmp = counts.clone();
            int remain = L.length;
            int j = i;
            while (remain > 0 && len + j <= S.length()) {
                if (m[j] == -1 || tmp[m[j]] == 0)
                    break;
                tmp[m[j]] --;
                remain --;
                j = j + len;
            }

            if (remain == 0)
                result.add(i);
        }
        return result;
    }
}