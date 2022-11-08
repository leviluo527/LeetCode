/*Solution: Using BinarySearch + Sorting + Map(To get the original res)
* Time: O(NlogN)
* Space: O(NlogN)
*/
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        int[][] origin = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            //Since the start is unique, we could just put the start in the intervals
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                origin[i][j] = intervals[i][j];
            }
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < origin.length; i++) {
            res[i] = curRes;
        }
        return res;
    }

    private int binarySearch(int[][] interval, int target) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (interval[mid][0] < target) {
                left = mid;
            } else if (intervals[mid][0] > target) {
                right = mid;
            } else {
                return map.get(interval[mid][0]);
            }
        }
        if (interval[left][0] >= target) {
            return map.get(interval[left][0]);
        }
        if (interval[right][0] >= target) {
            return map.get(interval[right][0]);
        }
        return -1;
    }
}
