public class Solution {
    public void connect(TreeLinkNode root) {
        HashMap<Integer, TreeLinkNode> map = new HashMap<Integer, TreeLinkNode>();
        traversal(root, 0, map);
    }
    
    private void traversal(
        TreeLinkNode node, 
        int level, 
        HashMap<Integer, TreeLinkNode> map
    ) {
        if (node == null)
            return;
            
        if (!map.containsKey(level)) {
            map.put(level, node);
        } else {
            TreeLinkNode cur = map.get(level);
            cur.next = node;
            map.put(level, node);
        }
        
        traversal(node.left, level + 1, map);
        traversal(node.right, level + 1, map);
    }
}