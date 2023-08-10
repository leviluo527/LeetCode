/*Solution: Two pointer + HashMap
* Time: O(N)
* Space: O(N)
*/
class WordDistance {

    private Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> list = map.getOrDefault(wordsDict[i], new ArrayList<>());
            list.add(i);
            map.put(wordsDict[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int freq1 = list1.get(i);
            int freq2 = list2.get(j);
            res = Math.min(res, Math.abs(freq1 - freq2));
            if (freq1 < freq2) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}