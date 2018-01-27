public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(minMoves(nums));
    }

    private static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return sum - (min * nums.length);
    }
}
