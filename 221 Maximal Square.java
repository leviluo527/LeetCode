/*Solution: DP, everytime check the three left top corner
* Time: O(N*M)
* Space: O(NM)
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] m = new int[row][col];
        for (int i = 0; i < row; i++) {
            m[i][0] = matrix[i][0] == '0' ? 0 : 1;
            if (matrix[i][0] != '0') {
                res = 1;
            }
        }
        for (int j = 0; j < col; j++) {
            m[0][j] = matrix[0][j] == '0' ? 0 : 1;
            if (matrix[0][j] != '0') {
                res = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') {
                    m[i][j] = 0;
                } else {
                    int cur = Math.min(m[i - 1][j], m[i][j - 1]);
                    cur = 1 + Math.min(cur, m[i - 1][j - 1]);
                    res = Math.max(res, cur * cur);
                    m[i][j] = cur;
                }
            }
        }
        return res;
    }
}