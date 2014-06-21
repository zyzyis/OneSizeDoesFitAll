public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i ++) {
            int p0 = i + 1;
            int p1 = num.length - 1;
            int sum = 0;
            while (p0 < p1) {
                sum = num[p0] + num[p1] + num[i];
                if (sum > target) {
                    p1 --;
                    closest = closer(sum, closest, target);
                } else if (sum == target) {
                    closest = target;
                    break;
                } else {                
                    p0 ++;
                    closest = closer(sum, closest, target);
                }
            }
            
            if (closest == target)
                break;
        }
        return closest;
    }
    
    private int closer(int v, int r, int target) {
        if (r == Integer.MAX_VALUE)
            return v;
       if (Math.abs(v - target) < Math.abs(r - target))
            return v;
       return r;
    }
}