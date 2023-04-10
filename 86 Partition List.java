/*Solution: Two pointer of Dummy head
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode curD = dummy;
        while (cur != null) {
            if (cur.val >= x) {
                curD.next = cur;
                cur = cur.next;
                curD = curD.next;
                curD.next = null;
            } else {
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
                prev.next = null;
            }
        }
        prev.next = dummy.next;
        return dummyHead.next;
    }
}