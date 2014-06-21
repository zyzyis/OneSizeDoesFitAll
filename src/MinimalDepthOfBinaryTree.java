public class Solution {
    public int minDepth(TreeNode root) {
        int result = 0;
        if (root != null) {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 && right != 0)
                result = right + 1;
            else if (left != 0 && right == 0)
                result = left + 1;
            else if (left == 0 && right == 0)
                result = 1;
            else
                result = Math.min(left, right) + 1;
        }
        return result;
    }
}