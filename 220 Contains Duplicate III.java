/*Solution: Use Bucket + HashMap to assign the values and reduce time
* Time: O(N)
* Space: O(Max(nums) / valueDiff)
*/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) {
            return false;
        }
        //Use bucket sort to solve
        //each key in map means a bucket
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //here we use valueDiff + 1 because we don't want nums[i] divide by 0
            int id = getId(nums[i], valueDiff + 1);
            //check for current id container and near container
            if (bucket.containsKey(id)) {
                return true;
            }
            if (bucket.containsKey(id - 1) && Math.abs(nums[i] - bucket.get(id - 1)) <= valueDiff) {
                return true;
            } 
            if (bucket.containsKey(id + 1) && Math.abs(nums[i] - bucket.get(id + 1)) <= valueDiff) {
                return true;
            }
            bucket.put(id, nums[i]);
            //Since we are check from first to last
            //when the index is larger than indexdiff, we will just remove the impossible pair from map
            if (i >= indexDiff) {
                bucket.remove(getId(nums[i - indexDiff], valueDiff + 1));
            }
        }
        return false;
    }

    //if num = -3 and diff = 5
    //Since java -3 / 5 = 0, but we need -3 / 5 = -1
    private int getId(int num, int diff) {
        return num < 0 ? (num + 1) / diff - 1 : num / diff;
    }
}