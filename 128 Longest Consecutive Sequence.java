/*Solution: Use a num_set, then iterative the set
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            //which means there is a larger sequence than current num
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                //therefore, we will check if there is a sequence with num + 1
                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}