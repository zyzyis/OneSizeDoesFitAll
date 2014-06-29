public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0, size = 0;
        int head = 0, tail = 0;
        while (true) {
            while (remain >= 0 && size < gas.length) {
                remain += gas[tail] - cost[tail];
                tail = (tail + 1) % gas.length;
                size ++;
            }
            
            while (remain < 0 && size < gas.length) {
                head = (head - 1 + gas.length) % gas.length;
                remain += gas[head] - cost[head];
                size ++;
            }
            
            if (size == gas.length)
                break;
        }
        
        return remain >= 0 ? head : -1;
    }
}
