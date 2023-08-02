/*Solution: Reverse the whole String, then reverse each word
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int left = 0;
        int right = 0;
        while (right < s.length) {
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            reverse(s, left, right - 1);
            left = right + 1;
            right++;
        }
    }

    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}