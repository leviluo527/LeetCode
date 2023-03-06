/* Solution1: Use sorting + HashMap
* Time: O(NK*log(K)) -> K is the max length of string
* Space: O(NK)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        int cur = 0;
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String curS = new String(arr);
            if (map.containsKey(curS)) {
                res.get(map.get(curS)).add(s);
            } else {
                map.put(curS, cur);
                List<String> newL = new ArrayList<>();
                newL.add(s);
                res.add(newL);
                cur++;
            }
        }
        return res;
    }
}