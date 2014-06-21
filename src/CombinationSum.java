public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {       
        if (candidates == null)
            return result;
        Arrays.sort(candidates);            
        ArrayList<Integer> path = new ArrayList<Integer>();
        search(candidates, target, 0, path);
        return result;
    }
    
    private void search(int[] candidates, int target, int index, ArrayList<Integer> path) {
        if (target == 0) {
            result.add((ArrayList<Integer>)(path.clone()));
            return;
        }
        
        for (int i = index; i < candidates.length; i ++) {
            if (candidates[i] > target)
                break;
            path.add(candidates[i]);
            search(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}