import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateTwo {
    public static void main(String[] args) {
        int[] nums = {1, 9, 5, 2, 4, 2};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 1) {
            return false;
        } else {
            Map<Integer, Integer> record = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (record.containsKey(nums[i])) {
                    return true;
                }
                if (record.values().size() >= k) {
                    record.remove(nums[i - k]);
                }
                record.put(nums[i], 1);
            }
            return false;
        }
    }
}
