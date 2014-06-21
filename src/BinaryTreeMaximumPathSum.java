public class Solution {
    private int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum_(root);
        return maxPathSum;
    }
    
    private int maxPathSum_(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = Math.max(0, maxPathSum_(root.left));
        int right = Math.max(0, maxPathSum_(root.right));
        int sum = root.val + left + right;
        maxPathSum = Math.max(maxPathSum, sum); 
        return Math.max(left + root.val, root.val + right);        
    }
}