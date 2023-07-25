/*Solution: Use Bit Manipulation
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;
        for (int i : nums) {
            //if only seenOnce, seenOnce will equal to the singleNumber
            //seenTwice will stay 0000
            seenOnce = (seenOnce ^ i) & (~seenTwice);
            //if seentwice, seenOnce will be 0, seentwice will be the number
            seenTwice = (seenTwice ^ i) & (~seenOnce);
            //if seen third, seenOnce will stay zero, seentwice will be zero too
        }
        return seenOnce;
    }
}