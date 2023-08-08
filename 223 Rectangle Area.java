/*Solution: All we need to do is find the common area by find the left, right, up, bot
* Time: O(1)
* Space: O(1)
*/
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rec1 = (ax2 - ax1) * (ay2 - ay1);
        int rec2 = (bx2 - bx1) * (by2 - by1);
        int left = Math.max(bx1, ax1);
        int right = Math.min(ax2, bx2);
        int up = Math.min(ay2, by2);
        int bot = Math.max(ay1, by1);
        int common = 0;
        if (left < right && bot < up) {
            common += (right - left) * (up - bot);
        }
        return rec1 + rec2 - common;
    }
}