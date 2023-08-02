/*Solution: Use hashset + substring
* Time: O(N-L)
* Space: O(N-L)
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> contains = new HashSet<>();
        if (s.length() < 10) {
            return res;
        }
        int i = 0;
        int j = 10;
        while (j <= s.length()) {
            String cur = s.substring(i, j);
            if (!seen.contains(cur)) {
                seen.add(cur);
            } else {
                if (!contains.contains(cur)) {
                    contains.add(cur);
                    res.add(cur);
                }
            }
            i++;
            j++;
        }
        return res;
    }
}