public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1024);
        List<ListNode> ps = new ArrayList<>();
        ListNode root = new ListNode(0);
        ListNode cur = root;
        boolean nothingNew = false;
        for (ListNode list : lists)
            ps.add(list);
            
        while (true) {
            nothingNew = true;
            for (int i = 0; i < ps.size(); i ++) {
                ListNode list = ps.get(i);
                if (list != null) {
                    nothingNew = false;
                    pq.offer(list.val);
                    ps.set(i, list.next);
                }
            }
            
            if (nothingNew)
                break;
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        
        while (pq.size() > 0) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        
        return root.next;
    }
}