/*Solution1: Own Solution: Use pointer
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int i = 0;
        int idx = 0;
        while (i < chars.length) {
            char tmp = chars[i];
            int count = 0;
            //Since we need to change the character at index also
            chars[idx] = tmp;
            while (i < chars.length && chars[i] == tmp) {
                i++;
                count++;
            }
            if (count != 1) {
                String cur = String.valueOf(count);
                for (int j = 0; j < cur.length(); j++) {
                    chars[idx++] = cur.charAt(j);
                }
            }
        }
        return idx;
    }
}
/*Solution2: LeetCode discuss, Use two pointer
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}
