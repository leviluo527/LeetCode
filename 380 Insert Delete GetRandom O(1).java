/*Solution: Use a map + list, we add the element to the last ind, put lastele to removed ind
* Time: O(1)
* Space: O(N)
*/
class RandomizedSet {
    private Random random = new Random();
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastEle = list.get(list.size() - 1);
        int ind = map.get(val);
        //set the lastEle to the ind of the removed val
        list.set(ind, lastEle);
        map.put(lastEle, ind);
        //delete the element
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */