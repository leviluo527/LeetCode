/*Solution: Sorting + priorityqueue
* Time: O(NlogN)
* Space: O(logN)
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 1;
        pq.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] < pq.peek()) {
                res++;
                pq.offer(cur[1]);
            } else {
                pq.poll();
                pq.offer(cur[1]);
            }
        }
        return res;
    }
}