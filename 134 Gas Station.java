/*Solution: DP thought
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curT = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curT += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curT < 0) {
                start = i + 1;
                curT = 0;
            } 
        }
        return total >= 0 ? start : -1;
    }
}