/*Solution: Use a HashMap, then start from right to left
* Whenever we saw a element that is smaller than prev, subtract
* Time: O(1)
* Space: O(1)
*/
class Solution {
    //create the map
    static HashMap<Character, Integer> values = new HashMap<>();
    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }

    public int romanToInt(String s) {
        int res = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            int curVal = map.get(cur);
            if (curVal >= prev) {
                res += curVal;
            } else {
                res -= curVal;
            }
            prev = curVal;
        }    
        return res;
    }
}