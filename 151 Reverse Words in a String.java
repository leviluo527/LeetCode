/*Solution: Reverse + Reverse each word + StringBuilder + Edge cases
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //first reverse the whole String
        String cur = reverse(s, 0, s.length() - 1);
        int left = 0;
        int right = 0;
        //Since String is immutable, we need to use a String builder
        StringBuilder sb = new StringBuilder();
        while (right < cur.length()) {
            while (right < cur.length() && cur.charAt(right) != ' ') {
                right++;
            }
            sb.append(reverse(cur, left, right - 1));
            if (right < cur.length() && cur.charAt(right) == ' ' && right != cur.length() - 1) {
                sb.append(' ');
            }
            while (right < cur.length() && cur.charAt(right) == ' ') {
                right++;
            }
            left = right;
        }
        return new String(sb.toString());
    }

    private String reverse(String cur, int left, int right) {
        //here we will delete the leading and end blank space;
        while (left < cur.length() && cur.charAt(left) == ' ') {
            left++;
        }
        while (right >= 0 && cur.charAt(right) == ' ') {
            right--;
        }
        char[] arr = new char[right - left + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cur.charAt(right--);
        }
        return new String(arr);
    }
}