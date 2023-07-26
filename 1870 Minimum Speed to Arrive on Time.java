/*Solution: Use Binary Search
* Time: O(NlogN)
* Space: O(1)
*/
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        int min = 1;
        return BinarySearch(min, max, dist, hour);
    }

    private int BinarySearch(int left, int right, int[] arr, double target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            double curTime = countTime(mid, arr);
            if (curTime > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (countTime(left, arr) <= target) {
            return left;
        }
        if (countTime(right, arr) <= target) {
            return right;
        }
        return -1;
    }

    private double countTime(int cur, int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sum += (double)arr[i] / cur;
            } else {
                if (arr[i] % cur == 0) {
                    sum += arr[i] / cur;
                } else {
                    sum += arr[i] / cur;
                    sum++;
                }
            }
        }
        return sum;
    }
}