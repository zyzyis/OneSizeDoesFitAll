public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode safe = new ListNode(0);
        safe.next = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode last = safe;

        while (true) {
            for (int i = 0; i < k - 1; i ++) {
                if (cur == null)
                    break;
                cur = cur.next;
            }
            
            if (cur == null)
                break;

            head = last.next;
            cur = last.next;
            pre = null;
            for (int i = 0; i < k; i ++) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            
            head.next = cur;
            last.next = pre;
            last = head;
        }
        return safe.next;
    }
}