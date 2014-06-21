public class Solution {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        StringBuffer buf = new StringBuffer();
        traversal(root, buf);
        return sum;
    }
    
    private void traversal(TreeNode node, StringBuffer buf) {
        if (node.left == null && node.right == null) {
            buf.append(node.val);
            sum += Integer.parseInt(buf.toString());
            buf.deleteCharAt(buf.length() - 1);
            return;
        }
        
        if (node.left != null) {
            buf.append(node.val);
            traversal(node.left, buf);
            buf.deleteCharAt(buf.length() - 1);
        }
        
        if (node.right != null) {
            buf.append(node.val);
            traversal(node.right, buf);
            buf.deleteCharAt(buf.length() - 1);            
        }
    }
}