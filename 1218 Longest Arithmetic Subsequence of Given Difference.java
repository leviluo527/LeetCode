/*Solution: Use a hashmap to dp, key means the number that occurs, values means before this number
* how many occurance to difference
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 1;
        for (int i : arr) {
            int beforeI = dp.getOrDefault(i - difference, 0);
            dp.put(i, beforeI + 1);
            ans = Math.max(ans, beforeI + 1);
        }
        return ans;
    }
}