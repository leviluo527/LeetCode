/*Solution1: Brute force, TLE
* Time: O(n^2)
* Space: O(n^2)
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}

/*Solution2: Use an array[60] to count the complement
* Time: O(N)
* Space: O(60)
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] reminder = new int[60];
        int res = 0;
        for (int i : time) {
            //if there are 1 song % 60 == 0, we will add 0
            //if there are 2 song % 60 == 0, we will add 1...
            if (i % 60 == 0) {
                res += reminder[0];
            } else {
                // we will add the number of the songs that 
                // reminder([i % 60] + reminder[60 - i % 60]) % 60
                res += reminder[60 - i % 60];
            }
            reminder[i % 60]++;
        }
        return res;
    }
}