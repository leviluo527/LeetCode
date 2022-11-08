/*Solution1: Use a boolean[] to store
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        for (int i : nums) {
            if (!visit[i - 1]) {
                visit[i - 1] = true;
            }
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
