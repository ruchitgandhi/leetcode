import java.util.Arrays;

public class CountNumbersInSortedArrayWithinLimit {
    public static void main(String[] args) {
        int scores[] = {4, 8, 7};
        int lowerLimits[] = {2, 4};
        int upperLimits[] = {8, 4};
        int results[] = jobOffers(scores, lowerLimits, upperLimits);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    private static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        Arrays.sort(scores);
        int results[] = new int[lowerLimits.length];

        for (int i = 0; i < lowerLimits.length; i++) {
            results[i] = countScoresWithinLimit(scores, lowerLimits[i], upperLimits[i]);
        }

        return results;
    }

    private static int countScoresWithinLimit(int[] scores, int lowerLimit, int upperLimit) {
        return upperBound(scores, upperLimit) - lowerBound(scores, lowerLimit) + 1;
    }

    private static int lowerBound(int[] scores, int lowerLimit) {
        int low = 0, high = scores.length - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (scores[mid] >= lowerLimit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(int[] scores, int upperLimit) {
        int low = 0, high = scores.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (scores[mid] <= upperLimit) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
