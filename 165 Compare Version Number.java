/*Solution: Use split to compare
* Time: O(N^2)
* Space: O(M) v1.size + v2.size
*/
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            String cur1 = v1[i];
            String cur2 = v2[i];
            int c1 = toDigit(cur1);
            int c2 = toDigit(cur2);
            if (c1 != c2) {
                return c1 < c2 ? -1 : 1;
            }
            i++;
        }
        while (i < v1.length) {
            int cur = toDigit(v1[i++]);
            if (cur != 0) {
                return 1;
            }
        }
        while (i < v2.length) {
            int cur = toDigit(v2[i++]);
            if (cur != 0) {
                return -1;
            }
        }
        return 0;
    }

    private int toDigit(String s) {
        int count = 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        while (i < s.length()) {
            count *= 10;
            count += s.charAt(i) - '0';
            i++;
        }
        return count;
    }
}