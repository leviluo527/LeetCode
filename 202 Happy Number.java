/*Solution: Use Hash Set + recursion
* Time: O(logn)
* Space: O(logn)
*/
class Solution {
    private Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int sum = 0;
        while (n > 0) {
            int cur = n % 10;
            n /= 10;
            sum += cur * cur;
        }
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        return isHappy(sum);        
    }
}