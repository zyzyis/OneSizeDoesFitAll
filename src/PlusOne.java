public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
            
        ArrayList<Integer> buf = new ArrayList<Integer>();
        int add = 1;
        int value = 0;
        for (int i = digits.length - 1; i >= 0; i --) {
            value = digits[i] + add;
            buf.add(value % 10);
            add = value / 10;
        }
        
        if (add != 0)
            buf.add(add);
            
        int[] result = new int[buf.size()];
        for (int i = buf.size() - 1; i >= 0; i --)
            result[buf.size() - i - 1] = buf.get(i);
        return result;
    }
}