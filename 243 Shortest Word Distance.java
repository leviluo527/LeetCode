/*Solution: Use two pointer
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int freq1 = Integer.MAX_VALUE;
        int freq2 = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                freq1 = i;
                res = Math.min(Math.abs(freq1 - freq2), res);
            } else if (wordsDict[i].equals(word2)) {
                freq2 = i;
                res = Math.min(Math.abs(freq2 -freq1), res);
            }
        }
        return res;
    }
}