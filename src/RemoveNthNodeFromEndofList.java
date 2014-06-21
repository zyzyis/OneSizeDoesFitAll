public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode safe = new ListNode(0);
        safe.next = head;
        ListNode p0 = safe;
        ListNode p1 = head;
        
        for (int i = 0; i < n - 1; i ++)
            p1 = p1.next;
        
        while (p1.next != null) {
            p0 = p0.next;
            p1 = p1.next;
        }
        
        p0.next = p0.next.next;
        return safe.next;
    }
}