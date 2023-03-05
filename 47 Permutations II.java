/*Solution: DFS
* Time: O(N * N - 1 * ... N - k + 1)
* Space: O(N)
*/
class Solution {
    private List<Integer> cur;
    private List<List<Integer>> res;
    private int[] nums;
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        cur = new ArrayList<>();
        res = new ArrayList<>();
        used = new boolean[nums.length];
        this.nums = nums;
        Arrays.sort(nums);
        helper();
        return res;
    }

    public void helper(){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }
            used[i]=true;
            cur.add(nums[i]);
            helper();
            used[i]=false;
            cur.remove(cur.size()-1);
        }
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}