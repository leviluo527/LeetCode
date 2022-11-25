/*Solution: Use a Hashmap to count a + b, then find -(c + d) is in the Hashmap
* Time: O(n^2)
* Space: O(n^2)
*/
class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            for (int j : b) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int res = 0;
        for (int i : c) {
            for (int j : d) {
                res += map.getOrDefault(-(i + j), 0);
            }
        }
        return res;
    }
}
