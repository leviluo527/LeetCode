/*Solution: Use Kadane's algorithm + HashMap
* Time: O(26 * 26 * n)
* Space: O(26)
*/
class Solution {
    public int largestVariance(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //Instantiate the map by character and frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                //if two character are same, skip
                if (c1 == c2) {
                    continue;
                }
                int c1Freq = 0;
                int c2Freq = 0;
                int c1Remaining = map.get(c1);
                for (char c : s.toCharArray()) {
                    if (c == c1) {
                        c1Freq++;
                        c1Remaining--;
                    }
                    if (c == c2) {
                        c2Freq++;
                    }

                    // If c2-count < c1-count then we reset the counters
                    // only if we know there are more c1 chars to come in the iteration
                    
					// c1Remaining check is required for the test case "baa" and c1=b && c2=a.
                    // We don't reset the counters if there are no more c1 chars left
                    if (c2Freq < c1Freq && c1Remaining > 0) {
                        c1Freq = 0;
                        c2Freq = 0;
                    }

                    if (c1Freq > 0 && c2Freq > 0) {
                        max = Math.max(max, c2Freq - c1Freq);
                    }
                }
            }
        }
        return max;
    }
}