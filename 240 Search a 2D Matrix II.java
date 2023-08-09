/*Solution: Search from top right or down left
* Time: O(M + N)
* Space: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        //start from botton left
        while (row >= 0 && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur > target) {
                row--;
            } else if (cur == target) {
                return true;
            } else {
                col++;
            }
        }
        return false;
    }
}