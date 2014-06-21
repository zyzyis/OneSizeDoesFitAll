public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode safe = new ListNode(0);
        safe.next = head;
        ListNode pre = safe;
        ListNode cur;
        ListNode tmp;
        while (pre.next != null) {
            cur = pre.next;
            if (cur.next == null)
                break;
            tmp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            pre = cur;
        }
        return safe.next;
    }
}