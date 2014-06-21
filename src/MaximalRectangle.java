public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix != null && matrix.length > 0) {
            int[][] height = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i ++) {
                for (int j = 0; j < matrix[0].length; j ++)
                    if (matrix[i][j] == '1')
                        height[i][j] = i > 0 ? height[i - 1][j] + 1 : 1;
                maxArea = Math.max(largestRectangleArea(height[i]), maxArea);
            }
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] height) {
        int[] height_ = new int[height.length + 1];
        for (int i = 0; i < height.length; i ++)
            height_[i + 1] = height[i];
        height = height_;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < height.length || !stack.isEmpty(); i ++) {
            int cur = i == height.length ? 0 : height[i];
            int top = stack.peek();
            while (height[top] > cur || i == height.length) {
                top = stack.pop();
                if (!stack.isEmpty())
                    maxArea = Math.max(maxArea, height[top] * (i - stack.peek() - 1));
                else {
                    maxArea = Math.max(maxArea, height[top] * (i - top));
                    break;
                }
                top = stack.peek();
            }
            if (i < height.length)
                stack.push(i);
        }
        return maxArea;
    }
}