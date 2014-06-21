public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode safe = new ListNode(0);
        safe.next = head;
        ListNode pre = safe;
        while (pre.next != null) {
            ListNode cur = pre.next;
            if (cur.next != null && cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == cur.val)
                    cur = cur.next;
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return safe.next;
    }
}