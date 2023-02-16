/*Solution: Use two for loop to find the longest palindrome
* Time: O(n^3)
* Space: O(1)
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] array = s.toCharArray();
        int longest = 0;
        String result = new String(array, 0, 1);
        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            int left = i;
            int right = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(array, i, j)) {
                    left = i;
                    right = j;
                    max = right - left;
                }
            }
            if (max > longest) {
                //result = new String(array, left, max + 1);
                result = s.substring(left, right + 1);
                longest = max;
            }
        }
        return result;
    }
    
    private boolean isPalindrome(char[] array, int left, int right) {
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}