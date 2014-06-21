public class Solution { 
    private ArrayList<ArrayList<String>> wordResult =
        new ArrayList<ArrayList<String>>();
    
    public ArrayList<ArrayList<String>> 
      findLadders( String start, String end, HashSet<String> dict) {
        if (dict == null || dict.size() == 0 || start.equals(end))
            return null;

        HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
        ArrayList<String> dictList = new ArrayList<String>(dict);
        ArrayList<ArrayList<Integer>> trace = new ArrayList<ArrayList<Integer>>();
        int startIndex = 0;
        int endIndex = 0;
        int[] minDist = new int[dictList.size()];
        for (int i = 0; i < dictList.size(); i ++) {
            if (dictList.get(i).equals(start))
                startIndex = i;
            if (dictList.get(i).equals(end))
                endIndex = i;
            indexMap.put(dictList.get(i), i);
            trace.add(new ArrayList<Integer>());
            minDist[i] = Integer.MAX_VALUE;
        }

        minDist[startIndex] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> queueHistory = new HashSet<Integer>();
        queue.offer(startIndex);
        queueHistory.add(startIndex);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            String curWord = dictList.get(cur);
            if (minDist[cur] >= minDist[endIndex])
                continue;
            for (int i = 0; i < curWord.length(); i ++) {
                for (int j = 0; j < 26; j ++) {
                    StringBuffer buf = new StringBuffer(curWord);
                    char c = buf.charAt(i);
                    if ((char)(j + 'a') == c)
                        continue;
                    buf.setCharAt(i, (char)(j + 'a'));
                    String newWord = buf.toString();
                    if (dict.contains(newWord)) {
                        int newWordIndex = indexMap.get(newWord);
                        if (minDist[cur] + 1 <= minDist[newWordIndex]) {
                            minDist[newWordIndex] = minDist[cur] + 1;
                            trace.get(cur).add(newWordIndex);
                            if (!queueHistory.contains(newWordIndex)) {
                                queue.offer(newWordIndex);
                                queueHistory.add(newWordIndex);
                            }
                        }
                    }
                }
            }
        }

        ArrayList<String> path = new ArrayList<String>();
        path.add(start);
        generate(startIndex, endIndex, dictList, trace, path);
        return wordResult;
    }

    private void generate(
        int cur,
        int end,
        ArrayList<String> dictList,
        ArrayList<ArrayList<Integer>> trace,
        ArrayList<String> path) {
        if (cur == end) {
            wordResult.add((ArrayList<String>)path.clone());
            return;
        }

        ArrayList<Integer> list = trace.get(cur);
        for (int i = 0; i < list.size(); i ++) {
            int nextId = list.get(i);
            path.add(dictList.get(nextId));
            generate(nextId, end, dictList, trace, path);
            path.remove(path.size() - 1);
        }
    }
}