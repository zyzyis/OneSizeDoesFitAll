public class Solution {
   public int removeDuplicates(int[] A) {
       int i = 0;
       if (A.length <= 0)
           return 0;
           
       for (int j = 1; j < A.length; j ++) {
           if (A[i] != A[j]) {
               A[i + 1] = A[j];
               i ++;
           }
       }
       return i + 1;
    }
}