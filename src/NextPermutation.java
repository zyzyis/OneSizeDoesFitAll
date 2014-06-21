public class Solution {
    public void nextPermutation(int[] num) {
        int left = -1, right = 0, tmp;
        for (int i = num.length - 1; i >= 0; i --)
            for (int j = i - 1; j >= 0; j --)
                if (num[i] > num[j] && left < j) {
                    left = j;
                    right = i;
                }
        
        if (left != -1) {
            tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            Arrays.sort(num, left + 1, num.length);
        } else 
            Arrays.sort(num);
    }
}