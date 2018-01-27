/*
    Maximum sum of sub array.

    Find maximum sum of movie ratings from array such that maximum 1 rating can be skipped among 2 numbers.
    i.e if first rating is skipped second has to be selected then again thrid can be skipped.

    {9, -1,-3,4,5}      Ans : 9 + -1 + 4 + 5
    {-1,-2, -3,-4,-5}   Ans : -2 + -4
*/
public class MaxSumOfSubArrayBySkippingAtMaxOne {
    public static void main(String[] args) {
        //int ratings[] = {9, -1,-3,4,5};
        int ratings[] = {-1, -2, -3, -4, -5};
        System.out.println(maximizeRatings(ratings));
    }

    static int maximizeRatings(int[] ratings) {

        int dp[] = new int[ratings.length];
        if (ratings.length > 0) {
            dp[0] = Math.max(ratings[0], 0);
            if (ratings.length > 1) {
                dp[1] = Math.max(ratings[0], ratings[1]);
                dp[1] = Math.max(dp[1], ratings[0] + ratings[1]);
                for (int i = 2; i < ratings.length; i++) {
                    dp[i] = Math.max(ratings[i] + dp[i - 1], ratings[i - 1] + dp[i - 2]);
                }
            }
            return dp[ratings.length - 1];
        }
        return 0;
    }
}
