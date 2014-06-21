public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        boolean merged = false;
        for (int i = 0; i < intervals.size(); i ++) {
            int cr = compare(intervals.get(i), newInterval);
            if (cr == 1 || merged) {
                result.add(intervals.get(i));
            } else if (cr == -1) {
                result.add(newInterval);
                merged = true;
                i --;
            } else {
                newInterval = merge(intervals.get(i), newInterval);
            }
        }
        
        if (!merged)
            result.add(newInterval);
        return result;
    }
    
    private int compare(Interval a, Interval b) {
        if (b.start > a.end)
            return 1;
        if (b.end < a.start)
            return -1;
        return 0;
    }
    
    private Interval merge(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
}