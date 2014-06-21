public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(slow);
        
        return merge(firstHalf, secondHalf);
    }
    
    private ListNode merge(ListNode p0, ListNode p1) {
        ListNode safe = new ListNode(0);
        ListNode cur = safe;
        while (p0 != null && p1 != null) {
            if (p0.val < p1.val) {
                cur.next = p0;
                p0 = p0.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        
        if (p0 == null)
            cur.next = p1;
        else
            cur.next = p0;
        return safe.next;
    }
}