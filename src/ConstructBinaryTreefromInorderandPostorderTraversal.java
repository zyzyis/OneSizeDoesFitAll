public class Solution {
    private HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> postorderMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null && postorder == null)
            return null;
        for (int i = 0; i < inorder.length; i ++) {
            inorderMap.put(inorder[i], i);
            postorderMap.put(postorder[i], i);
        }
        
        return dfs(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }
    
    private TreeNode dfs(int[] inorder, int[] postorder, int i0, int i1, int p0, int p1) {
        if (i0 == i1)
            return null;
        int tmp = postorder[p1 - 1];
        int inorderIndex = inorderMap.get(tmp);
        int len = i1 - inorderIndex;
        TreeNode newNode = new TreeNode(tmp);
        
        newNode.left = dfs(inorder, postorder, i0, inorderIndex, p0, p1 - len);
        newNode.right = dfs(inorder, postorder, inorderIndex + 1, i1, p1 - len, p1 - 1);
        return newNode;
    }
}