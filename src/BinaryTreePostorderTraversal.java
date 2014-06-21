public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right != null && cur.right != lastVisited)
                    cur = cur.right;
                else {
                    result.add(cur.val);
                    stack.pop();
                    lastVisited = cur;
                    cur = null;
                }
            }
        }
        return result;        
    }
}