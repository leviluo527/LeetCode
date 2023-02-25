/*Solution1: Use HashMap + HashSet + Sorting the list
* Time: O(n^2)
* Space: O(n)
*/
class Solution {
    private Set<List<Integer>> viewed;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        viewed = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(res, i, nums);
        }
        return res;
    }

    private void twoSum(List<List<Integer>> res, int ind, int[] nums) {
        int target = 0 - nums[ind];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = ind + 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = ind + 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (target - nums[i] == nums[i] && map.get(nums[i]) == 1) {
                    continue;
                } else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[ind]);
                    cur.add(nums[i]);
                    cur.add(target - nums[i]);
                    Collections.sort(cur);
                    if (!viewed.contains(cur)) {
                        res.add(new ArrayList<Integer>(cur));
                        viewed.add(cur);
                    }
                }
            }
        }
        return;
    }
}

/*Solution2: Use Two Pointer + Sort
* Time:O(n^2)
* Space: O(n)
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}