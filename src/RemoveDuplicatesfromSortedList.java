public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
            
        ListNode pre = head;
        while (pre.next != null) {
            ListNode next = pre.next;
            if (pre.val == next.val) {
                pre.next = next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}