/*Solution: Use a dummy node
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode curH = head;
        while (curH != null) {
            if (curH.val == val) {
                curH = curH.next;
            } else {
                cur.next = curH;
                curH = curH.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        return dummy.next;
    }
}