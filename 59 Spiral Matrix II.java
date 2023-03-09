/*Solution: straigt forward
* Time: O(N^2)
* Space: O(1)
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int cur = 1;
        while (left <= right && up <= down) { 
            if (left == right && up == down) {
                res[up][left] = cur++;
                break;
            }
            for (int i = left; i < right; i++) {
                res[up][i] = cur;
                cur++;
            }
            for (int i = up; i < down; i++) {
                res[i][right] = cur++;
            }
            for (int i = right; i > left; i--) {
                res[down][i] = cur++;
            }
            for (int i = down; i > up; i--) {
                res[i][left] = cur++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}