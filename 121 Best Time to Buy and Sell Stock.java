/*Solution: Easy
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i : prices) {
            if (i < minPrice) {
                minPrice = i;
            } else if (i - minPrice > max) {
                max = i - minPrice;
            }
        }
        return max;
    }
}