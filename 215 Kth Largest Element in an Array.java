/*Solution: Priority Queue
* Time: O(nlogK)
* Space: O(k)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer u1, Integer u2) {
                if (u1.equals(u2)) {
                    return 0;
                }
                return u1 < u2 ? -1 : 1;
            }
        });
        for (int i : nums) {
            if (pq.size() == k) {
                if (i > pq.peek()) {
                    pq.poll();
                    pq.add(i);
                }
            } else {
                pq.add(i);
            }
        }
        return pq.peek();
    }
}