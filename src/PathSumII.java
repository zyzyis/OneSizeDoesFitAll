public class Solution {
    private ArrayList<ArrayList<Integer>> result = 
        new ArrayList<ArrayList<Integer>>();
        
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return result;
        ArrayList<Integer> path = new ArrayList<Integer>();
        search(root, sum, path);
        return result;
    }
    
    private void search(TreeNode node, int sum, ArrayList<Integer> path) {
        sum = sum - node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0)
                result.add((ArrayList<Integer>)path.clone());
        } else {
            if (node.left != null)
                search(node.left, sum, path);
            
            if (node.right != null)
                search(node.right, sum, path);
        }
        path.remove(path.size() - 1);
    }
}