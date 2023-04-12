/*Solution: DFS
* Time: O(3^4 * 4) 3-> each integer most 3 digits
* Space: O(3*4) 4-> seperate the string into 4 integers
*/
class Solution {
    private List<String> res;
    private String s;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        this.s = s;
        String cur = "";
        dfs(cur, 0, 0);
        return res;
    }

    private void dfs(String cur, int ind, int dotUse) {
        if (dotUse > 4) {
            return;
        } else if (dotUse == 4 && ind == s.length()) {
            res.add(new String(cur));
            return;
        }
        for (int i = 1; i < 4; i++) {
            //to check if the substring(ind, ind + i) is larger than s.length
            if (ind + i > s.length()) {
                break;
            }
            String curS = s.substring(ind, ind + i);
            if (curS.length() > 1 && curS.startsWith("0") || Integer.parseInt(curS) >= 256) {
                break;
            }
            dfs(cur + curS + (dotUse == 3 ? "" : "."), ind + i, dotUse + 1);
        }
    }
}