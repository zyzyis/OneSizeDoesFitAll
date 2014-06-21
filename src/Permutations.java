public class Solution {
    private ArrayList<ArrayList<Integer>> result = 
        new ArrayList<ArrayList<Integer>>();
        
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null)
            return result;
        search(num, 0, new ArrayList<Integer>(), new boolean[num.length]);
        return result;
    }
    
    private void search(int[] num, int index, ArrayList<Integer> path, boolean[] mark) {
        if (index == num.length) {
            result.add((ArrayList<Integer>)path.clone());
            return;
        }
        
        for (int i = 0; i < num.length; i ++) {
            if (mark[i])
                continue;
            path.add(num[i]);            
            mark[i] = true;
            search(num, index + 1, path, mark);
            path.remove(path.size() - 1);
            mark[i] = false;
        }        
    }
}