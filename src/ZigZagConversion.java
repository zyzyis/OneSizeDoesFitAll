public class Solution {
    public String convert(String s, int nRows) {
        if (s == null)
            return s;
        ArrayList<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < nRows; i ++)
            rows.add(new StringBuffer());
        int i = 0, delta = 1;
        for (int k = 0; k < s.length(); k ++) {
            rows.get(i).append(s.charAt(k));
            i = (i + delta) % nRows;
            if (nRows > 2 && i == 0) {
                if (delta == 1)
                    i = nRows - 2;
                delta = -delta;
            }
        }
        StringBuffer buf = new StringBuffer();
        for (i = 0; i < nRows; i ++)
            buf.append(rows.get(i));
        return buf.toString();
    }