/*Solution: Use a int[26] as a set
* Time: O(s.length)
* Space: O(26)
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] schar = new int[26];
        for (char c : s.toCharArray()) {
            schar[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            schar[c - 'a']--;
            if (schar[c - 'a'] < 0) {
                return false;
            }
            
        }
        return true;
    }
}