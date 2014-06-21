public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        search(n, k, 0, 1, new ArrayList<Integer>());
        return result;
    }

    private void search(int n, int k, int i, int m, ArrayList<Integer> path) {
        if (i == k) {
            result.add((ArrayList<Integer>)(path.clone()));
            return;
        }
        
        for (int j = m; j <= n; j ++) {
            path.add(j);
            search(n, k, i + 1, j + 1, path);
            path.remove(path.size() - 1);
        }
    }
}