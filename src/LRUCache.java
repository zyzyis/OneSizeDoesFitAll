public class LRUCache {
    class ListNode {
        int v;
        int key;
        ListNode next;
        public ListNode(int v, int key) { this.v = v; this.key = key; }
    }

    HashMap<Integer, ListNode> indexMap = new HashMap<Integer, ListNode>();
    int capacity;
    ListNode safe;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        safe = new ListNode(0, 0);
        tail = safe;
    }

    public int get(int key) {
        if (!indexMap.containsKey(key))
            return -1;
        ListNode t = pop(key);
        tail.next = t;
        indexMap.put(key, tail);
        tail = tail.next;
        return t.v;
    }

    public void set(int key, int value) {
        if (indexMap.containsKey(key)) {
            ListNode t = pop(key);
            t.v = value;
            tail.next = t;
            indexMap.put(key, tail);
            tail = tail.next;
        } else {
            if (indexMap.size() == capacity)
                pop(safe.next.key);
            tail.next = new ListNode(value, key);
            indexMap.put(key, tail);
            tail = tail.next;
        }
    }

    private ListNode pop(int key) {
        ListNode pre = indexMap.get(key);
        ListNode cur = pre.next;
        pre.next = cur.next;
        indexMap.remove(key);
        if (pre.next != null)
            indexMap.put(pre.next.key, pre);
        cur.next = null;
        if (cur == tail)
            tail = pre;
        return cur;
    }
}