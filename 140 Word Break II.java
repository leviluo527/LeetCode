/*Solution: DFS + StringBuilder + HashSet
* Time: O(n^2 + 2^n + w)
* Space: O(W + 2^w)
*/
class Solution {
    private List<String> res;
    private Set<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dict = new HashSet<>(wordDict);
        helper(new StringBuilder(), s, 0);
        return res;
    }

    private void helper(StringBuilder sb, String s, int ind) {
        if (ind == s.length()) {
            res.add(new String(sb.toString()));
        }
        for (int i = ind + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(ind, i))) {
                sb.append(s.substring(ind, i));
                if (i != s.length()) {
                    sb.append(" ");
                }
                helper(sb, s, i);
                if (i != s.length()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.delete(sb.length() - i + ind, sb.length());
            }
        }
    }
}