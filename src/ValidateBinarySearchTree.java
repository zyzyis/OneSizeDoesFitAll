public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        if (!isValidBST(root.left, min, root.val)) 
            return false;
        if (!isValidBST(root.right, root.val, max))
            return false;
        return true;
    }
}