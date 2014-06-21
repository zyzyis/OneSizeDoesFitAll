public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int count = ratings.length;
        int[] candy = new int[ratings.length];
        for (int i = 1; i < ratings.length; i ++)
            if (candy[i] <= candy[i - 1] && ratings[i] > ratings[i - 1])
                candy[i] = candy[i - 1] + 1;
        for (int i = ratings.length - 2; i >= 0; i --)
            if (candy[i] <= candy[i + 1] && ratings[i] > ratings[i + 1])
                candy[i] = candy[i + 1] + 1;
        for (int i : candy)
            count += i;
        return count;
    }
}