public class Solution {
    private HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null && preorder == null)
            return null;
        for (int i = 0; i < inorder.length; i ++)
            inorderMap.put(inorder[i], i);
        return dfs(inorder, preorder, 0, inorder.length, 0, preorder.length);
    }
    
    private TreeNode dfs(int[] inorder, int[] preorder, int i0, int i1, int p0, int p1) {
        if (i0 == i1)
            return null;
        int tmp = preorder[p0];
        int index = inorderMap.get(tmp);
        int len = index - i0;
        TreeNode newNode = new TreeNode(tmp);
        
        newNode.left = dfs(inorder, preorder, i0, index, p0 + 1, p1 + len + 1);
        newNode.right = dfs(inorder, preorder, index + 1, i1, p0 + len + 1, p1);
        return newNode;
    }
}