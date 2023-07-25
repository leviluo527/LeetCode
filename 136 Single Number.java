/*Solution: Bit manipulate, since two same number ^= 0
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int singleNumber(int[] nums) {
        //since every two numbers xor equals to 0
        //therefore the only number left is result
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}