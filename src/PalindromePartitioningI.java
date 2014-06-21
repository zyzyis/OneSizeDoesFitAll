public class Solution {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        boolean[][] m = new boolean[s.length()][];
        for (int i = 0; i < s.length(); i ++) {
            m[i] = new boolean[s.length()];
            m[i][i] = true;
        }
        
        for (int k = 1; k < s.length(); k ++)
            for (int i = 0; i + k < s.length(); i ++) {
                boolean tmp = s.charAt(i) == s.charAt(i + k);
                m[i][i + k] = k == 1 ? tmp : (m[i + 1][i + k - 1] && tmp);
            }
        
        search(s, 0, new ArrayList<String>(), m);
        return result;
    }
    
    private void search(String s, int k, ArrayList<String> list, boolean[][] m) {
        if (k == s.length()) {
            result.add((ArrayList<String>)list.clone());
            return;
        }
        
        for (int i = k; i < s.length(); i ++) {
            if (m[k][i]) {
                list.add(s.substring(k, i + 1));
                search(s, i + 1, list, m);
                list.remove(list.size() - 1);
            }
        }
    }
}