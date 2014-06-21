public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end))
            return 0;
            
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        hash.put(start, 1);
        queue.offer(start);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (int i = 0; i < word.length(); i ++) {
                StringBuffer buf = new StringBuffer(word);
                for (char ch = 'a'; ch <= 'z'; ch ++) {
                    buf.setCharAt(i, ch);
                    String nstring = buf.toString();
                    if (dict.contains(nstring) && !hash.containsKey(nstring)) {
                        hash.put(nstring, hash.get(word) + 1);
                        queue.offer(nstring);
                    }
                    if (hash.containsKey(end))
                        return hash.get(end);
                }
            }
        }
        assert false;
        return 0;
    }
}