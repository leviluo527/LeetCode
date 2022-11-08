Three Solutions:
1. Use HashSet
2. Use boolean[] as set
3. Use inplace *= -1
/*Solution1: Use HashSet to see contains duplicate
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (set.contains(i)) {
                res.add(i);
            } else {
                set.add(i);
            }
        }
        return res;
    }
}

/*Solution2: Use a boolean[] as a set
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean[] set = new boolean[nums.length - 1];
        List<Integer> res = new ArrayList<>();
        for(int i : nums) {
            if (set[i - 1]) {
                res.add(i);
            } else {
                set[i - 1] = true;
            }
        }
        return res;
    }
}

/*Solution3: Use inplace change nums to -nums
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            //Means seen before
            if (nums[Math.abs(i) - 1] < 0) {
                res.add(Math.abs(i));
            }
            nums[Math.abs(i) - 1] *= -1;
        }
    }
}
