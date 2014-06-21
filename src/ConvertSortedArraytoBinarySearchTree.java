public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
            
        return generate(num, 0, num.length);
    }
    
    private TreeNode generate(int[] num, int start, int end) {
        if (start >= end)
            return null;
        int mid = (end - start) / 2 + start;
        TreeNode node = new TreeNode(num[mid]);
        node.left = generate(num, start, mid);
        node.right = generate(num, mid + 1, end);
        return node;
    }
}