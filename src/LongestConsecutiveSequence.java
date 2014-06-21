public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        HashSet<Integer> choices = new HashSet<Integer>();
        int maxLen = 1;
        
        if (num == null || num.length == 0)
            return 0;
            
        for (int i = 0; i < num.length; i ++)
            choices.add(num[i]);
            
        while (choices.size() != 0) {
            int choice = choices.iterator().next();
            choices.remove(choice);
            int len = count(choice, cache, choices);
            cache.put(choice, len);
            if (len > maxLen)
                maxLen = len;
        }        
        return maxLen;
    }
    
    private int count(
        int choice, 
        HashMap<Integer, Integer> cache, 
        HashSet<Integer> choices
    ) {
        if (cache.containsKey(choice - 1))
            return cache.get(choice - 1) + 1;
            
        int result = 0;
        if (choices.contains(choice - 1)) {
            result = count(choice - 1, cache, choices);
            choices.remove(choice - 1);
            cache.put(choice - 1, result);
        }
        return result + 1;
    }
}