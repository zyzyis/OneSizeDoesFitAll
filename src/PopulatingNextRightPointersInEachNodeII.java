public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
            
        TreeLinkNode current = root;
        TreeLinkNode nextLevelHead = null;
        TreeLinkNode nextLevelTail = null;
        
        while (current != null) {
            if (current.left != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.left;
                    nextLevelTail = current.left;
                } else {
                    nextLevelTail.next = current.left;
                    nextLevelTail = nextLevelTail.next;
                }
            }
            
            if (current.right != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current.right;
                    nextLevelTail = current.right;
                } else {
                    nextLevelTail.next = current.right;
                    nextLevelTail = nextLevelTail.next;
                }                
            }
            
            if (current.next != null)
                current = current.next;
            else {
                current = nextLevelHead;
                nextLevelHead = null;
            }
        }
    }
}