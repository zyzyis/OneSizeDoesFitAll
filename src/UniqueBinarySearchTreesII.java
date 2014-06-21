public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n == 0) {
            ArrayList<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = i + 1;
        HashSet<TreeNode> treeSet = generate(num, 0, n);
        return new ArrayList<TreeNode>(treeSet);
    }
    
    private HashSet<TreeNode> generate(int[] num, int start, int end) {
        if (start >= end)
            return null;
        HashSet<TreeNode> result = new HashSet<TreeNode>();
        for (int i = start; i < end; i++) {
            HashSet<TreeNode> left = generate(num, start, i);
            HashSet<TreeNode> right = generate(num, i + 1, end);
            
            if (left == null && right == null) {
                TreeNode node = new TreeNode(num[i]);
                result.add(node);
            } else if (left == null) {
                for (TreeNode rightEntry : right) {
                    TreeNode node = new TreeNode(num[i]);
                    node.right = rightEntry;
                    result.add(node);
                }    
            } else if (right == null) {
                for (TreeNode leftEntry : left) {
                    TreeNode node = new TreeNode(num[i]);
                    node.left = leftEntry;
                    result.add(node);
                }                    
            } else for (TreeNode leftEntry : left) {
                for (TreeNode rightEntry : right) {
                    TreeNode node = new TreeNode(num[i]);
                    node.left = leftEntry;
                    node.right = rightEntry;
                    result.add(node);
                }
            }
        }
        return result;
    }
}