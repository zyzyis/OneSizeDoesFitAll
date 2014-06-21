public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i ++)
            result.add(factor(rowIndex, i));
        return result;
    }
    
    private int factor(int row, int k) {
        if (k == 0)
            return 1;
        double a = 1, b = 1;
        for (int i = row - k + 1; i <= row; i ++)
            a *= i;
        
        for (int j = 2; j <= k; j ++)
            b *= j;
        return (int)Math.round(a / b);
    }
}