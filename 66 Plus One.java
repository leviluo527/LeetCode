/*Solution: Easy Sol
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int count = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            count += cur;
            digits[i] = count % 10;
            count /= 10;
            if (count == 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = count;
        int k = 1;
        for (int i : digits) {
            res[k++] = i;
        }
        return res;
    }
}