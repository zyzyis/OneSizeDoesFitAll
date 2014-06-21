public class Solution {
    public void flatten(TreeNode root) {
        flatten_(root);    
    }
    
    private TreeNode flatten_(TreeNode node) {
        if (node == null)
            return null;

        TreeNode tmp = node.right;
        TreeNode tail = node;
        if (node.left != null) {
            tail = flatten_(node.left);        
            node.right = node.left;
            node.left = null;
        }

        if (tmp != null) {           
            tail.right = tmp;
            tail = flatten_(tmp);
        }
        return tail;
    }
}