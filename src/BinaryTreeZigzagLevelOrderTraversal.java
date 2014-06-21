public class Solution {
    private ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return levels;        
        
        traverse(root, 0);
        for (int i = 0; i < levels.size(); i ++)
            if (i % 2 == 1)
                Collections.reverse(levels.get(i));
        return levels;
    }
    
    private void traverse(TreeNode node, int level) {
        if (level >= levels.size()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            levels.add(list);
        } else {
            ArrayList<Integer> list = levels.get(level);
            list.add(node.val);
        }        
        
        if (node.left != null)
            traverse(node.left, level + 1);
        if (node.right != null)
            traverse(node.right, level + 1);
    }
}