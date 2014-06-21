public class Solution {
    private Set<String> tokenSet = new HashSet<>();
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> d = new ArrayList<>();
        for (int i = 0; i <= s.length(); i ++)
            d.add(new ArrayList<Integer>());
        d.get(0).add(0);
        for (int i = 1; i <= s.length(); i ++)
            for (int j = 0; j < i; j ++) {
                String token = s.substring(j, i);
                if (dict.contains(token) && d.get(j).size() != 0)
                    d.get(i).add(j);
            }
        // use backtracking to construct all the strings    
        search(d, s.length(), new ArrayList<String>(), s);
        return new ArrayList<String>(tokenSet);
    }
    
    private void search(ArrayList<ArrayList<Integer>> d, int k, ArrayList<String> tokens, String s) {
        if (k == 0) {
            StringBuffer buf = new StringBuffer();
            for (int i = tokens.size() - 1; i >= 0; i --)
                buf.append(tokens.get(i)).append(" ");
            tokenSet.add(buf.toString().trim());
        } else {
            ArrayList<Integer> breaks = d.get(k);
            for (int i = 0; i < breaks.size(); i ++) {
                tokens.add(s.substring(breaks.get(i), k));
                search(d, breaks.get(i), tokens, s);
                tokens.remove(tokens.size() - 1);
            }
        }
    }
}