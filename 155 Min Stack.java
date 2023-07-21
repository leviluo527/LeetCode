/*Solution: Use Two Stack
* Time: O(1)
* Space: O(N)
*/
class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> s;
    public MinStack() {
        min = new Stack<>();
        s = new Stack<>();
    }
    
    public void push(int val) {
        if (min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(val, min.peek()));
        }
        s.push(val);
    }
    
    public void pop() {
        min.pop();
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}