/*Solution: Use a h[] as a HashMap
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public String getHint(String secret, String guess) {
        int countBull = 0;
        int countCow = 0;
        int[] h = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                countBull++;
            } else {
                if (h[s - '0'] < 0) 
                    countCow++;
                if (h[g - '0'] > 0)
                    countCow++;
                h[s - '0']++;
                h[g - '0']--;
            }
        }
        return "" + countBull + "A" + countCow + "B";

    }
}