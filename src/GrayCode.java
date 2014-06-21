public class Solution {
    private HashSet<Integer> set = new HashSet<Integer>();
    private ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> grayCode(int n) {
        boolean[] state = new boolean[n];
        set.add(0);
        result.add(0);
        int nv = 0;
        while ((nv = getNext(state, nv)) != -1) {
            set.add(nv);
            result.add(nv);
        }
        return result;
    }
    
    private int getNext(boolean[] state, int value) {
        for (int i = 0; i < state.length; i ++) {
            state[i] = !state[i];
            int sum = 0;
            for (int j = 0; j < state.length; j ++)
                if (state[j])
                    sum |= 1 << j;
            if (!set.contains(sum))
                return sum;
            state[i] = !state[i];
        }
        return -1;
    }
}