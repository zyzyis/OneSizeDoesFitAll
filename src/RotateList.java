public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode p0 = head;
        int count = 0;
        for (p0 = head; p0 != null; p0 = p0.next)
            count ++;
        
        int mod = (count != 0) ? n % count : 0;
        ListNode result = head;
        if (mod != 0) {
            p0 = head;
            ListNode p1 = head;
            for (int i = 0; i < mod; i++)
                p1 = p1.next;
                
            while (p1.next != null) {
                p0 = p0.next;
                p1 = p1.next;
            }
            
            p1.next = head;
            result = p0.next;
            p0.next = null;
        }
        
        return result;
    }
}