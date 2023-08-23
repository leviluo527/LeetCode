/*Solution: Binary Search
* Time: O(LogN)
* Space: O(1)
*/
class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int n = citations.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}