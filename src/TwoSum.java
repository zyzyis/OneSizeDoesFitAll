public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i ++) 
            map.put(numbers[i], i + 1);
        
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i ++) {
            int remain = target - numbers[i];
            if (map.containsKey(remain)) {
                result[0] = i + 1;
                result[1] = map.get(remain);
                if (result[0] != result[1])
                    break;
            }
        }
        return result;
    }
}