public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
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