/*Solution: Use recursion
* Time: O(N)
* Space: O(N / 2)
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        cur.next = swapPairs(next.next);
        next.next = cur;
        return next;
    }
}