public class Solution {
    private ArrayList<String> result = new ArrayList<String>();
    private char[][] dictMap;
    public ArrayList<String> letterCombinations(String digits) {
        dictMap = new char[10][];
        dictMap[0] = new char[] { ' ' };
        dictMap[1] = new char[] { '_' };
        dictMap[2] = new char[] { 'a', 'b', 'c' };
        dictMap[3] = new char[] { 'd', 'e', 'f' };
        dictMap[4] = new char[] { 'g', 'h', 'i' };
        dictMap[5] = new char[] { 'j', 'k', 'l' };
        dictMap[6] = new char[] { 'm', 'n', 'o' };
        dictMap[7] = new char[] { 'p', 'q', 'r', 's' };
        dictMap[8] = new char[] { 't', 'u', 'v' };
        dictMap[9] = new char[] { 'w', 'x', 'y', 'z' };

        char[] text = new char[digits.length()];
        build(digits, 0, text);
        return result;
    }
    
    private void build(String digits, int index, char[] text) {
        if (index == digits.length()) {
            result.add(new String(text));
            return;
        }
        
        char[] dict = dictMap[digits.charAt(index) - '0'];
        for (int i = 0; i < dict.length; i ++) {
            text[index] = dict[i];
            build(digits, index + 1, text);
        }
    }
}