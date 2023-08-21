/*Solution: Tail Recursion
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int next = 0;
        while (num != 0) {
            next += num % 10;
            num /= 10;
        }
        return addDigits(next);
    }
}
/*Solution2: ????????
* Time: O(1)
* Space: O(1)
*/
class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}