/*Solution: Recursive + tail to hold reversed tail's value
* Time: O(right)
* Space: O(1)
*/
class Solution {
    private int right;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.right = right;
        if (left == right) {
            return head;
        }
        ListNode cur = head;
        int i = 1;
        if (left == 1) {
            return reverseNode(head, left);
        }
        //find one node before head
        while (i < left - 1) {
            cur = cur.next;
            i++;
        }
        cur.next = reverseNode(cur.next, left);
        return head;
    }

    private ListNode reverseNode(ListNode head, int curRight) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode tail = head;
        while (curRight <= right) {
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
            curRight++;
        }
        tail.next = head;
        return prev;
    }
}