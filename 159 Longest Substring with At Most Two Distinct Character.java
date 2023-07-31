/*Solution: HashMap
* Time: O(N)
* Space: O(2)
*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }

        int left = 0;
        int right = 0;
        int maxLen = 2;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == 3) {
                int delInd = Collections.min(map.values());
                map.remove(s.charAt(delInd));
                left = delInd + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}