/*Solution: DFS
* Time: O(N 2^N)
* Space: O(N * N)
*/
class Solution {
    private List<List<String>> res;
    private String s;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        this.s = s;
        helper(0, new ArrayList<>());
        return res;
    }

    private void helper(int ind, List<String> cur) {
        if (ind >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalin(ind, i, s)) {
                cur.add(s.substring(ind, i + 1));
                helper(i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalin(int left, int right, String cur) {
        if (right - left < 1) {
            return true;
        }
        while (left < right) {
            if (cur.charAt(left) != cur.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}