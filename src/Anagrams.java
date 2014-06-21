public class Solution {
    public ArrayList<String> anagrams(String[] strs) {        
        ArrayList<String> result = new ArrayList<String>();
        if (strs == null)
            return result;        
        HashSet<String> indexCache = new HashSet<String>();
        HashSet<String> toAdd = new HashSet<String>();
        String[] root = new String[strs.length];
        
        for (int i = 0; i < strs.length; i ++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String newString = new String(array);
            root[i] = newString;
            if (indexCache.contains(newString))              
                toAdd.add(root[i]);                
            else 
                indexCache.add(root[i]);
        }
        
        for (int i = 0; i < root.length; i ++)
            if (toAdd.contains(root[i]))
                result.add(strs[i]);                            
        return result;    
    }


}