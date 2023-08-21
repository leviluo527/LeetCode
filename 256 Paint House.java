/*Solution: 2D inplace DP
* Time： O(3N)
* Space: O(1)
*/
class Solution {
    public int minCost(int[][] costs) {
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] += Math.min(costs[i - 1][(j + 1) % 3], costs[i - 1][(j + 2) % 3]);
            }
        }
        int row = costs.length - 1;
        return Math.min(Math.min(costs[row][0], costs[row][1]), costs[row][2]);
    }
}