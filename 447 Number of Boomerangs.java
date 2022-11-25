/*Solution: Use HashMap
* Time: O(n^2)
* Space: O(n)
*/
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        //base case
        //Since we need at least 3 points to construct a boomerangs
        if (points.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            //traverse the map
            for (Integer key : map.keySet()) {
                int cur = map.get(key);
                //Math condition, it should have (n) * (n - 1) conditions
                res += cur * (cur - 1)
            }
            return res;
        }
    }

    private int getDistance(int[] a1, int[] a2) {
        int x = a1[0] - a2[0];
        int y = a1[1] - a2[1];
        return x * x + y * y;
    }
}
