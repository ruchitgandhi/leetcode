public class HouseRobber_Two {
    public static void main(String[] args) {
        int nums[] = {1, 7, 9, 2};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int result = 0;
        if (nums.length > 0) {
            if (nums.length == 1) {
                return nums[0];
            }
            result = Math.max(houseRobberOne(nums, 1, nums.length - 1), houseRobberOne(nums, 0, nums.length - 2));
        }
        return result;
    }

    private static int houseRobberOne(int[] nums, int start, int end) {
        int dp[] = new int[end - start + 1];
        dp[0] = nums[start];
        if (end - start > 0) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                dp[i - start] = Math.max(nums[i] + dp[i - start - 2], dp[i - start - 1]);
            }
            return dp[end - start];
        }
        return nums[start];
    }
}
