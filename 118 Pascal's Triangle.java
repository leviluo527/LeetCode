/*Solution: Use Recursion
* Time: O(n^2)
* Space: O(n^2)
*/
class Solution {
    private int numRows;
    private List<List<Integer>> res;
    public List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>();
        this.numRows = numRows;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(cur);
        if (numRows == 1) {
            return res;
        }
        generateCur(1);
        return res;
    }

    private void generateCur(int curRow) {
        if (curRow >= numRows) {
            return;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> last = res.get(curRow - 1);
        for (int i = 0; i <= curRow; i++) {
            if (i == 0 || i == curRow) {
                cur.add(1);
                continue;
            } else {
                cur.add(last.get(i - 1) + last.get(i));
            }
        }
        res.add(new ArrayList<>(cur));
        generateCur(curRow + 1);
    }
}