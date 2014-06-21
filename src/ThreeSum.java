public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> result = 
            new HashSet<ArrayList<Integer>>();        
        for (int i = 0; i < num.length; i ++) {
            int remain = -num[i];
            int p0 = i + 1;
            int p1 = num.length - 1;
            while (p0 < p1) {
                if (num[p0] + num[p1] == remain) {
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(num[i]);
                    solution.add(num[p0]);
                    solution.add(num[p1]);
                    result.add(solution);
                    p0 ++;
                } else if (num[p0] + num[p1] > remain)
                    p1 --;
                else
                    p0 ++;                
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}