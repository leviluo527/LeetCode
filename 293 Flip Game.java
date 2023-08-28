/*Solution: StringBuilder
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i + 1 < currentState.length()) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(currentState);
                res.add(sb.replace(i, i + 2,"--").toString());
            }
            i++;
        }
        return res;
    }
}