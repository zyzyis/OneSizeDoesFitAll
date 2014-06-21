public class Solution {
    class Token {
        char c;
        boolean isStar;
        boolean isDot;
        public Token(char c, boolean isStar) {
            isDot = c == '.';
            this.c = c;
            this.isStar = isStar;
        }
    }

    public boolean isMatch(String s, String p) {
        ArrayList<Token> tokens = new ArrayList<Token>();
        for (int i = 0; i < p.length(); i ++) {
            char c = p.charAt(i);
            boolean isStar = false;
            if (i + 1 < p.length() && p.charAt(i + 1) == '*')  {
                isStar = true;
                i ++;
            }
            Token token = new Token(c, isStar);
            tokens.add(token);
        }

        return eat(s, tokens, 0, 0);
    }

    private boolean eat(
            String s,
            ArrayList<Token> tokens,
            int sindex,
            int tindex
    ) {
        if (tindex == tokens.size())
            if (sindex == s.length())
                return true;
            else
                return false;

        Token token = tokens.get(tindex);
        boolean result = false;
        if (token.isStar) {
            result = eat(s, tokens, sindex, tindex + 1);
            if (!result)
                for (int i = sindex; i < s.length(); i ++) {
                    char c = s.charAt(i);
                    if (c != token.c && !token.isDot)
                        break;
                    result = eat(s, tokens, i + 1, tindex + 1);
                    if (result)
                        break;
                }
        } else if (token.isDot) {
            if (sindex == s.length())
                result = false;
            else
                result = eat(s, tokens, sindex + 1, tindex + 1);
        } else {
            if (sindex == s.length())
                result = false;
            else {
                char c = s.charAt(sindex);
                if (c != token.c)
                    result = false;
                else
                    result = eat(s, tokens, sindex + 1, tindex + 1);
            }
        }
        return result;
    }
}