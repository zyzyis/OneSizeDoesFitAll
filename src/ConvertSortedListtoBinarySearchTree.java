public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            tmp.add(cur.val);
            cur = cur.next;
        }
        
        return generate(tmp, 0, tmp.size());
    }
    
    private TreeNode generate(ArrayList<Integer> num, int start, int end) {
        if (start >= end)
            return null;
        int mid = (end - start) / 2 + start;
        TreeNode node = new TreeNode(num.get(mid));
        node.left = generate(num, start, mid);
        node.right = generate(num, mid + 1, end);
        return node;
    }
}