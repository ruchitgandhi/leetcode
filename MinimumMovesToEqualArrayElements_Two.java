import java.util.Arrays;

public class MinimumMovesToEqualArrayElements_Two {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(minMoves2(nums));
    }

    private static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int result = 0;
        for (int num : nums) {
            result += Math.abs(nums[mid] - num);
        }
        return result;
    }
}
