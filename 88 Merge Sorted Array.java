/*Solution: Use Three pointer, start form end to scan
* Time: O(M + N)
* Space: O(1)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (k >= 0) {
            if (j < 0) {
                break;
            }
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}