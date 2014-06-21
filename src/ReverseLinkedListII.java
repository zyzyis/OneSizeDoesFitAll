public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode safe = new ListNode(0);
        safe.next = head;
        ListNode pre = safe;
        ListNode tail = null;
        ListNode next = null;
        for (int i = 0; i < m - 1; i++)
            pre = pre.next;
        tail = pre.next;
        ListNode cur = tail;
        ListNode tmp = null;
        for (int i = m; i <= n; i++) {
            next = cur.next;
            cur.next = tmp;
            tmp = cur;
            cur = next;
        }
        pre.next = tmp;
        tail.next = next;
        return safe.next;
    }
}