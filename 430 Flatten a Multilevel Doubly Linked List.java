Two solutions:
1. Use recursive dfs
2. Use Stack
/*Solution1: Use dfs, remember tail
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        //use dummy node to handle edge case
        Node dummy = new Node(0, null, head, null);
        dfs(dummy, head);
        //use dummy.next.prev, cause we don't know if head is the cur head
        dummy.next.prev = null;
        return dummy.next;
    }

    private Node dfs(Node prev, Node cur) {
        if (cur == null) {
            return prev;
        }
        prev.next = cur;
        cur.prev = prev;
        Node tmpNext = cur.next;
        Node tail = dfs(cur, cur.child);
        //remember to set the child to null
        cur.child = null;
        return dfs(tail, tmpNext);
    }
}

/*Solution2: Use Stack to do the dfs
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0, null, head, null);
        //use prev and cur Node to hold the tail
        Node prev, cur = dummy;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            //Cause stack is FILO, we first handle the next pointer
            if (cur.next != null) {
                stack.push(cur.next);
            }
            //then handle the children, therefore the children will be process first
            if (cur.child != null) {
                stack.push(cur.child);
                //remember to set the child pointer to null
                cur.child = null;
            }
            //update the prev pointer
            prev = cur;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}
