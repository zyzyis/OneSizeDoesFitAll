public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {    
        HashSet<ArrayList<Integer>> store = new HashSet<ArrayList<Integer>>();
        if (S == null)
            return null;

        Arrays.sort(S);
        ArrayList<Integer> path = new ArrayList<Integer>();
        search(S, 0, store, path); 
        return new ArrayList<ArrayList<Integer>>(store);
    }
    
    private void search(
        int[] s, 
        int index, 
        HashSet<ArrayList<Integer>> store,
        ArrayList<Integer> path
    ) {
        if (index == s.length) {
            store.add((ArrayList<Integer>)path.clone());
            return;
        }
        
        search(s, index + 1, store, path);
        path.add(s[index]);
        search(s, index + 1, store, path);
        path.remove(path.size() - 1);
    }
}