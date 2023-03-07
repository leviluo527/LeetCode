/*Solution: Use left, right, up, down bound
* Time: O(M*N)
* Space: O(1)
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int row = matrix.length;
        if (row == 0) {
          return result;
        }
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int up = 0;
        int down = row - 1;

        while (left < right && up < down) {
          for (int i = left; i <= right; i++) {
            result.add(matrix[up][i]);
          }
          for (int i = up + 1; i <= down - 1; i++) {
            result.add(matrix[i][right]);
          }
          for (int i = right; i >= left; i--) {
            result.add(matrix[down][i]);
          }
          for (int i = down - 1; i >= up + 1; i--){
            result.add(matrix[i][left]);
          }
          left++;
          right--;
          up++;
          down--;
        }

        //first case: nothing else in the list
        if (left > right || up > down) {
          return result;
        }
        //case2: 1 colum left
        if (left == right) {
          for (int i = up; i <= down; i++) {
            result.add(matrix[i][left]);
          }
        } else {
          for (int i = left; i <= right; i++) {
            result.add(matrix[up][i]);
          }
        }
        return result;
      }
}