/*Solution1: HashSet
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        int[] res = new int[2];
        int j = 0;
        for (int i : set) {
            res[j++] = i;
        }
        return res;
    }
}

/*Solution2: Two BitMask
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int i : nums) {
            bitmask ^= i;
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, bitmask ^ x};
    }
}