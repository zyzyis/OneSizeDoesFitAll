public class Solution {
    public void sortColors(int[] A) {
        int r = 0;
        int w = 0;
        int b = A.length - 1;
        
        while (w <= b) {
            switch(A[w]) {
                case 0:
                    swap(A, w ++, r ++);
                    break;
                case 1:
                    w ++;
                    break;
                case 2:
                    swap(A, w, b --);
                    break;
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}