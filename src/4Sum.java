public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if (num == null || num.length < 4)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> result = 
            new HashSet<ArrayList<Integer>>();        
        for (int i = 0; i < num.length; i ++) {
            for (int j = i + 1; j < num.length; j ++) {
                int remain = target - num[i] - num[j];
                int p0 = j + 1;
                int p1 = num.length - 1;
                while (p0 < p1) {
                    if (num[p0] + num[p1] == remain) {
                        ArrayList<Integer> solution = new ArrayList<Integer>();
                        solution.add(num[i]);
                        solution.add(num[j]);
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
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}