/*Solution: Two Pointer
* Time: O(N)
* Space: O(1)
*/
public class ZigzagIterator {
    private List<List<Integer>> vectors = new ArrayList<>();
    private LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors.add(v1);
        this.vectors.add(v2);
        int index = 0;
        for (List<Integer> vec : this.vectors) {
            if (vec.size() > 0)
                // <index_to_vec, index_to_element_within_vec>
                this.queue.add(new Pair<Integer, Integer>(index, 0));
            index++;
        }
    }

    public int next() {
        // if (this.queue.size() == 0)
        // throw new Exception("Out of elements!");

        // <index_to_vec, index_to_element_within_vec>
        Pair<Integer, Integer> pointer = this.queue.removeFirst();
        Integer vecIndex = pointer.getKey();
        Integer elemIndex = pointer.getValue();
        Integer nextElemIndex = elemIndex + 1;
        // append the pointer for the next round
        // if there are some elements left.
        if (nextElemIndex < this.vectors.get(vecIndex).size())
            this.queue.addLast(new Pair<>(vecIndex, nextElemIndex));

        return this.vectors.get(vecIndex).get(elemIndex);
    }

    public boolean hasNext() {
        return this.queue.size() > 0;
    }
}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */