public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
            
        ListNode safe = new ListNode(Integer.MIN_VALUE);
        safe.next = head;
        
        ListNode cur = head.next;
        head.next = null;
        ListNode pre = safe;
        while (cur != null) {
            pre = safe;
            while (true) {
                if (pre.next == null) {
                    pre.next = cur;
                    cur = cur.next;
                    pre.next.next = null;
                    break;
                } else if (cur.val < pre.next.val) {
                    ListNode tmp = pre.next;
                    pre.next = cur;
                    cur = cur.next;
                    pre.next.next = tmp;
                    pre = pre.next;
                    break;
                } else {
                    pre = pre.next;
                }
            }
        }
        return safe.next;
    }
}