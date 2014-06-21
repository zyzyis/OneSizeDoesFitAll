public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private HashMap<Integer, Integer> countMap = new HashMap<>();
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0)
            return new ArrayList<>();
            
        for (int x : num)
            if (countMap.containsKey(x))
                countMap.put(x, countMap.get(x) + 1);
            else
                countMap.put(x, 1);
                
        search(num.length, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void search(int len, int index, ArrayList<Integer> path) {
        if (index == len) {
            result.add((ArrayList<Integer>)path.clone());
            return;
        }
        
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == 0)
                continue;
            path.add(key);            
            countMap.put(key, countMap.get(key) - 1);
            search(len, index + 1, path);
            path.remove(path.size() - 1);
            countMap.put(key, countMap.get(key) + 1);
        }        
    }
}