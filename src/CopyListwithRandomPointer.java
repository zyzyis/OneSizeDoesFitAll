public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> nodeIndex = 
            new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode safe = new RandomListNode(0);
        RandomListNode newCur = safe;
        for (RandomListNode cur = head; cur != null; cur = cur.next) {
            newCur.next = new RandomListNode(cur.label);
            nodeIndex.put(cur, newCur.next);
            newCur = newCur.next;
        }
        
        for (RandomListNode cur = head; cur != null; cur = cur.next) {
            RandomListNode source = nodeIndex.get(cur);
            if (cur.random != null) {
                RandomListNode dist = nodeIndex.get(cur.random);
                source.random = dist;
            }
        }
        
        return safe.next;        
    }
}