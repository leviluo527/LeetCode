/*Solution1: Use a Stack + Set + Map, set to remove duplicate, map to remain the smallest order
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        //put the last occurance of s[i] to the map
        for (int i  = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}