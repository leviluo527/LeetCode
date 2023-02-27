/*Solution: DFS
* Time: O(4^n / n^ 3/2)
* Space: O(4^n / n^ 3/2)
*/
class Solution {
    private List<String> res;
    private int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        if (n == 0) {
            return res;
        }
        dfs(new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(StringBuilder sb, int leftUse, int rightUse) {
        if (leftUse < rightUse) {
            return;
        }
        if (leftUse + rightUse == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (leftUse < n) {
            sb.append('(');
            dfs(sb, leftUse + 1, rightUse);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightUse < n) {
            sb.append(')');
            dfs(sb, leftUse, rightUse + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}