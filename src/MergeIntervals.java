public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            ArrayList<Interval> tmp = new ArrayList<Interval>();
            boolean inserted = false;
            for (Interval p : list) {
                int r = interval == null ? -1 : compare(p, interval);
                if (r == -1)
                    tmp.add(p);
                else if (r == 1) {
                    inserted = true;
                    tmp.add(interval);
                    tmp.add(p);
                    interval = null;
                } else
                    interval = new Interval(
                        Math.min(p.start, interval.start), 
                        Math.max(p.end, interval.end));                    
            }
            
            if (!inserted)
                tmp.add(interval);
            list = tmp;
        }
        return list;
    }

    private int compare(Interval a, Interval b) {
        if (a.end < b.start)
            return -1;
        if (a.start > b.end)
            return 1;
        return 0;
    }
}