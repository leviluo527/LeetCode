/*Solution1: Straight forware
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int res = 1;
        int i = 0;
        while (i < arr.length && k > 0) {
            if (arr[i] != res) {
                k--;
                res++;
            } else {
                res++;
                i++;
            }
        }
        if (k > 0) {
            res += k;
        }
        return res - 1;
    }
}

/*Solution2: Binary Search
* Time: O(logn)
* Space: O(1)
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (arr[m] - m - 1 < k) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return left + k;
    }
}