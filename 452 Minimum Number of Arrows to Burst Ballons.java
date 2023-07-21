/*Solution: Sorting by points[i][1] then if there is a bigger start, we will plus arrows
* Time: O(nlogn)
* Space: O(logn)
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int endInd = points[0][1];
        int arrow = 1;
        for (int i = 0; i < points.length; i++) {
            if (endInd < points[i][0]) {
                arrow++;
                endInd = points[i][1];
            }
        }
        return arrow;
    }
}