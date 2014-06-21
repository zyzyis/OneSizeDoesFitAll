public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
            
        ListNode safe = new ListNode(0);
        ListNode pre = safe;
        int add = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + add;
            pre.next = new ListNode(tmp % 10);
            add = tmp / 10;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            while (l1 != null) {
                int tmp = l1.val + add;
                pre.next = new ListNode(tmp % 10);
                pre = pre.next;
                add = tmp / 10;
                l1 = l1.next;
            }
        }
        
        if (l2 != null) {
            while (l2 != null) {
                int tmp = l2.val + add;
                pre.next = new ListNode(tmp % 10);
                pre = pre.next;
                add = tmp / 10;
                l2 = l2.next;
            }            
        }
        
        if (add != 0) {
            pre.next = new ListNode(add);
        }
        return safe.next;
    }
}