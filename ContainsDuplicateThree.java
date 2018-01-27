import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateThree {
    public static void main(String[] args) {
        /*int[] nums = {1,9,5,2,4,6};
        int k = 2;
        int t = 3;*/
        int[] nums = {-1, 2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 1) {
            return false;
        } else {
            long bucket, newNumber;
            Map<Long, Long> record = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                newNumber = (long) nums[i] + Integer.MAX_VALUE;
                bucket = newNumber / ((long) t + 1);
                if (record.containsKey(bucket) || record.containsKey(bucket - 1) && (newNumber - record.get(bucket - 1) <= t)
                        || record.containsKey(bucket + 1) && (record.get(bucket + 1) - newNumber <= t)) {
                    return true;
                }
                if (record.values().size() >= k) {
                    record.remove(((long) nums[i - k] + Integer.MAX_VALUE) / ((long) t + 1));
                }
                record.put(bucket, newNumber);
            }
            return false;
        }
    }
}
