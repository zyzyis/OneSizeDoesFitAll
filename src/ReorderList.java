public class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        if (head == null || head.next == null)
            return;
            
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        ListNode cur = reverse(slow);
        ListNode result = merge(head, cur);
        head.next = result.next;
    }
    
    private ListNode merge(ListNode p0, ListNode p1) {
        ListNode safe = new ListNode(0);
        ListNode cur = safe;
        while (p0 != null || p1 != null) {
            if (p0 != null) {
                cur.next = p0;
                p0 = p0.next;
                cur = cur.next;
            }
            
            if (p1 != null) {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            }
        }
        return safe.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode tmp = null;
        while (head.next != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        head.next = pre;
        return head;
    }
}