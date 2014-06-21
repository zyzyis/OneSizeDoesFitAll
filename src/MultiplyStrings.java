public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] buf = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i ++)
            for (int j = 0; j < num2.length(); j ++) {
                int nc1 = num1.charAt(num1.length() - i - 1) - '0';
                int nc2 = num2.charAt(num2.length() - j - 1) - '0';
                buf[i + j] += nc1 * nc2;
            }

        StringBuffer result = new StringBuffer();
        for (int k = 0, carry = 0; k < buf.length - 1 || carry != 0; k ++) {
            int tmp = buf[k] + carry;
            carry = tmp / 10;
            result.append((char)(tmp % 10 + '0'));
        }
        return result.reverse().toString();
    }
}