public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
            if (b == null)
                break;
            b = b.next;
            if (a == b && a != null)
                return true;
        }
        return false;
    }
}