import java.util.ArrayList;
import java.util.List;

public class MergeIntervals_Q3 {
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        if (intervals.isEmpty()) {
            return mergedIntervals;
        }

        int[] currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            
            // Check if the current interval overlaps with the next interval
            if (currentInterval[1] >= interval[0]) {
                // Merge the overlapping intervals by updating the end time
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Add the non-overlapping interval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = interval; // Set the current interval to the next interval
            }
        }

        // Add the last interval to the result
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{8, 10});
        intervals.add(new int[]{10, 12});
        intervals.add(new int[]{11, 12});
        intervals.add(new int[]{12, 15});
        intervals.add(new int[]{16, 18});
        intervals.add(new int[]{19, 20});

        List<int[]> merged = mergeIntervals(intervals);

        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
