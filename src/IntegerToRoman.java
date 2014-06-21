public class Solution {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int t = (int)Math.floor(num / 1000.0);
        builder.append(build(t, 'M', '-', '-'));
        int h = (int)Math.floor((num - t * 1000) / 100.0);
        builder.append(build(h, 'C', 'D', 'M'));
        int e = (int)Math.floor((num - t * 1000 - h * 100) / 10.0);
        builder.append(build(e, 'X', 'L', 'C'));
        int u = (int)Math.floor(num % 10);
        builder.append(build(u, 'I', 'V', 'X'));
        return builder.toString();
    }
    
    private String build(int n, char l, char m, char u) {
        switch(n) {
            default: return "";
            case 1: return "" + l;
            case 2: return "" + l + l;
            case 3: return "" + l + l + l;
            case 4: return "" + l + m;
            case 5: return "" + m;
            case 6: return "" + m + l;
            case 7: return "" + m + l + l;
            case 8: return "" + m + l + l + l;
            case 9: return "" + l + u;
        }
    }
}