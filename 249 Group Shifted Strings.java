/*Solution: Use HashMap, count each string to 'a' begins hash code
* Time: O(N*eachword.length)
* Space: O(N * eachword)
*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String construct = constructString(s);
            List<String> listcur = map.getOrDefault(construct, new ArrayList<>());
            listcur.add(s);
            map.put(construct, listcur);
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    private String constructString(String cur) {
        char[] arr = cur.toCharArray();
        int count = arr[0] - 'a';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 'a' < count) {
                int next = count - (arr[i] - 'a') - 1;
                char x = 'z';
                x -= next;
                arr[i] = x;
            } else {
                arr[i] -= count;
            }
        }
        return new String(arr);
    }
}