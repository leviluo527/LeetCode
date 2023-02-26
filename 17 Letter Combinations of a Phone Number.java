/*Solution1: Iterative way, use hashmap
* Time: O(4^digits.length)
* Space: O(1)
*/
class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        char first = digits.charAt(0);
        String cur = letters.get(first);
        for (int i = 0; i < cur.length(); i++) {
            combinations.add(Character.toString(cur.charAt(i)));
        }
        for (int j = 1; j < digits.length(); j++) {
            combine(digits.charAt(j));
        }
        return combinations;
    }

    private void combine(char digit) {
        String cur = letters.get(digit);
        int size = combinations.size();
        for (int i = size - 1; i >= 0; i--) {
            String curAdd = combinations.get(i);
            for (int j = 0; j < cur.length(); j++) {
                String newAdd = curAdd + cur.charAt(j);
                combinations.add(newAdd);
            }
            combinations.remove(curAdd);
        }
    }
}

/*Solution2: DFS
* Time: O(4^digits.length)
* Space: O(digits.length)
*/
class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String digit;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        digit = digits;
        combine(0, new StringBuilder());
        return combinations;
    }

    private void combine(int ind, StringBuilder sb) {
        if (sb.length() == digit.length()) {
            combinations.add(sb.toString());
            return;
        }
        String cur = letters.get(digit.charAt(ind));
        for (char let : cur.toCharArray()) {
            sb.append(let);
            combine(ind + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}