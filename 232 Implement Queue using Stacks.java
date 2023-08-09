/*Solution: Design
* Time: O(1)
* Space: O(1)
*/
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2= new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            swap();
        }
        return s2.pop();
    }
    
    public int peek() {
        if (s2.isEmpty()) {
            swap();
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void swap() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}