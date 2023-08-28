/*Solution: Two Priority queue
* Time: O(N)
* Space: O(N)
*/
class MedianFinder {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return j.compareTo(i);
            }
        });
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() != max.size()) {
            return (double)max.peek();
        } else {
            return (double)(min.peek() + max.peek()) * 0.5;
        }
    }
}