public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode firstHead = new ListNode(0);
        ListNode secondHead = new ListNode(0);
        ListNode firstTail = firstHead;
        ListNode secondTail = secondHead;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = null; // reset null
            if (cur.val < x) {
                firstTail.next = cur;
                firstTail = firstTail.next;
            } else {
                secondTail.next = cur;
                secondTail = secondTail.next;
            }
            cur = tmp;
        }
        
        firstTail.next = secondHead.next;
        return firstHead.next;
    }
}