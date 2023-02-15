/*Solution: % + /
* Time: O(max(num.length, logk))
* Space: O(max(num.length, logk))
*/
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            count += num[i];
            count += k % 10;
            k /= 10;
            res.add(count % 10);
            count /= 10;
        }
        while (k != 0 || count != 0) {
            count += k % 10;
            res.add(count % 10);
            count /= 10;
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}