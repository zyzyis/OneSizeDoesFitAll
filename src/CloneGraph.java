public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<Integer, UndirectedGraphNode> graph = new HashMap<Integer, UndirectedGraphNode>();
        HashSet<Integer> history = new HashSet<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList();
        queue.offer(node);
        graph.put(node.label, new UndirectedGraphNode(node.label));
        history.add(node.label);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode copy = graph.get(cur.label);

            for (int i = 0; i < cur.neighbors.size(); i ++) {
                UndirectedGraphNode neighbor = cur.neighbors.get(i);
                if (graph.containsKey(neighbor.label)) {
                    copy.neighbors.add(graph.get(neighbor.label));
                } else {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    graph.put(neighbor.label, newNode);
                    copy.neighbors.add(newNode);
                }
                
                if (!history.contains(neighbor.label)) {
                    queue.offer(neighbor);
                    history.add(neighbor.label);
                }
            }
        }
        return graph.get(node.label);
    }
}