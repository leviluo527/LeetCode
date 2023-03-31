/*Solution: let the 2D matrix as a 1D array
* Time: O(log(m*n))
* Space: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int right = row * col - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = matrix[mid / col][mid % col];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}