public class Solution {
        public ArrayList<String> fullJustify(String[] words, int L) {
            ArrayList<ArrayList<String>> context = new ArrayList<>();
            ArrayList<Integer> length = new ArrayList<>();
            int i = 0;
            while (i < words.length) {
                ArrayList<String> line = new ArrayList<>();
                int size = 0, spaceCount = 0;
                do {
                    line.add(words[i]);
                    size += words[i].length();
                    i ++;
                    spaceCount ++;
                } while (i < words.length && words[i].length() + size + spaceCount <= L);
                context.add(line);
                length.add(size);
            }
            // calculate space for each token and print to string
            ArrayList<String> result = new ArrayList<>();
            for (int z = 0; z < context.size(); z ++) {
                ArrayList<String> line = context.get(z);
                StringBuilder buf = new StringBuilder();
                for (int j = 0; j < line.size(); j ++) {
                    int space = 0;                                           // calculate space for each cell
                    if (line.size() == 1 || z == context.size() - 1)         // last line 
                        if (j < line.size() - 1)                             // last line but not last word
                            space = 1;
                        else
                            space = L - length.get(z) - line.size() + 1;     // deduct word length and spaces
                    else if (z != context.size() - 1 && j != line.size() - 1) { // not last line and not last word
                        space = (L - length.get(z)) / (line.size() - 1);
                        if (j < (L - length.get(z)) % (line.size() - 1))
                            space ++;
                    }

                    buf.append(line.get(j));
                    for (int k = 0; k < space; k ++)
                        buf.append(' ');
                }
                result.add(buf.toString()); // trim the extra space
            }
            return result;
        }
}