public class Solution {
    private HashSet<ArrayList<Integer>> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {       
        if (candidates == null)
            return new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, target, 0, new ArrayList<Integer>());
        return new ArrayList<ArrayList<Integer>>(set);
    }
    
    private void search(int[] candidates, int target, int index, ArrayList<Integer> path) {
        if (target == 0) {
            set.add((ArrayList<Integer>)(path.clone()));
            return;
        }
        
        for (int i = index; i < candidates.length; i ++) {
            if (candidates[i] > target)
                break;
            
            path.add(candidates[i]);
            search(candidates, target - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}