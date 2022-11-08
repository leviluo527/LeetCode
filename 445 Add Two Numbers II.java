/*Solution1: Use Three Stacks
* Time: O(l1.size() + l2.size())
* Space: O(l1.size() + l2.size())
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int count = 0;
        ListNode dummy = new ListNode();
        Stack<Integer> res = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int cur1 = s1.isEmpty() ? 0 : s1.pop();
            int cur2 = s2.isEmpty() ? 0 : s2.pop();
            cur1 = count + cur1 + cur2;
            count = cur1 / 10;
            cur1 %= 10;
            res.push(cur1);
        }
        if (count != 0) {
            res.push(count);
        }
        ListNode cur = dummy;
        while (!res.isEmpty()) {
            cur.next = new ListNode(res.pop());
            cur = cur.next;
        }
        return dummy.next;
    }
}
//Slow!!!!

/*Solution2: Use Reverse List + next = new Node, next.next = head, head = next
* Time: O(N1 + N2)
* Space: O(max(N1, N2))
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            // keep the next node
            ListNode tmp = head.next;
            // reverse the link
            head.next = last;
            // update the last node and the current node
            last = head;
            head = tmp;
        }
        return last;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // get the current values
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;

            // current sum and carry
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;

            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;

            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }
}
