/*Solution: Use HashMap + HashSet
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> occur = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (occur.contains(map.get(i))) {
                return false;
            }
            occur.add(map.get(i));
        }
        return true;
    }
}