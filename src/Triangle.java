public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        
        int[] levels = new int[triangle.size()];
        int[] nextLevels = new int[triangle.size()];
        levels[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); i ++) {
            nextLevels[0] = levels[0] + triangle.get(i).get(0);
            nextLevels[i] = levels[i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j ++) 
                nextLevels[j] = 
                    Math.min(levels[j], levels[j - 1]) + triangle.get(i).get(j);
            levels = nextLevels;
            nextLevels = new int[triangle.size()];
        }
        
        int minPath = levels[0];
        for (int i = 1; i < triangle.size(); i ++)
            minPath = Math.min(minPath, levels[i]);
        return minPath;
    }
}