public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= numRows; i ++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i; j ++) {
                if (j == 0)
                    row.add(1);
                else if (j == i - 1)
                    row.add(1);
                else {
                    ArrayList<Integer> preRow = result.get(i - 2);
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
}