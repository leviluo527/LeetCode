/*Solution: Use brain
* Time: O(N^2)
* Space: O(1)
*/
class Solution {
    int n;
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        n = matrix.length - 1;
        rotate(matrix, 0);
    }

    private void rotate(int[][] m, int ind) {
        if (ind > n / 2) {
            return;
        }
        for (int i = 0 + ind; i < n - ind; i++) {
            int tmp = m[ind][i];
            m[ind][i] = m[n - i][ind];
            m[n - i][ind] = m[n - ind][n - i];
            m[n - ind][n - i] = m[i][n - ind];
            m[i][n - ind] = tmp;
        }
        rotate(m, ind + 1);
    }
}