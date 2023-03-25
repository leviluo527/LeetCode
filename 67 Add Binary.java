/*Solution: Stringbuilder + reverse
* Time: O(N)
* Space: O(N)S
*/
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (count != 0 || i >= 0 || j >= 0) {
            int cur = 0;
            if (i >= 0) {
                cur += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                cur += b.charAt(j) - '0';
                j--;
            }
            cur += count;
            count = cur / 2;
            cur %= 2;
            sb.append(cur);
        }
        return reverse(sb.toString().toCharArray());
    }

    private String reverse(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
        return new String(s);
    }
}