/* Solution: DP
* if two intervals are overlapping, we want to remove the interval that has the
* longer end point -- the longer interval will always overlap with more or the
* same number of future intervals compared to the shorter one
* Time: O(nLogn)
* Space: O(nLogn)
*/
class Solution {
  class myComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      return a[1] - b[1];
    }
  }

  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, new myComparator());
    int end = intervals[0][1];
    int count = 1;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= end) {
        end = intervals[i][1];
        count++;
      }
    }
    return intervals.length - count;
  }
}
