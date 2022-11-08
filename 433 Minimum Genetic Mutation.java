/*Sotuion1: Use queue to bfs, use set to remove duplicate String
* Time: O(banks.length)
* Space: O(1)
*/
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start == end) {
            return 0;
        }
        int level = 0;
        Set<String> seen = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(end)) {
                    return level;
                }
                List<String> curList = findListString(cur, bank);
                for (int j = 0; j < curList.size(); j++) {
                    if (!set.contains(curList.get(j))) {
                        q.offer(curList.get(j));
                        set.add(curList.get(j));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> findListString(String cur, String[] bank) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            if (onlyOneDiff(cur, bank[i])) {
                res.add(bank[i]);
            }
        }
        return res;
    }

    private boolean onlyOneDiff(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 0 ? false : true;
    }
}
