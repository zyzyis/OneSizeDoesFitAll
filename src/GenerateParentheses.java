public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        char[] buf = new char[2 * n];
        generate(0, 0, n, 0, buf, result);
        return result;
    }
    
    private void generate(
      int left, int right, int n, int i, char[] buf, ArrayList<String> result) {
        if (left == n && right == n) {
            result.add(new String(buf));
            return;
        }    
        
        if (left < n) {
            buf[i] = '(';
            generate(left + 1, right, n, i + 1, buf, result);
        }
        
        if (left > right) {
            buf[i] = ')';
            generate(left, right + 1, n, i + 1, buf, result);
        }
    }
}