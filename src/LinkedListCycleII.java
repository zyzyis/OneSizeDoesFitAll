public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode a = head, b = head;
        boolean hasCycle = false;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
            if (b == null)
                break;
            b = b.next;
            if (a == b && a != null) {
                hasCycle = true;
                break;
            }
        }
        ListNode c = null;
        if (hasCycle) {
            for (c = head; c != a.next; c = c.next) {
                b = a;
                while (b != c && b.next != a)
                    b = b.next;
                if (b == c)
                    break;
            }
        }
        return c;
    }
}