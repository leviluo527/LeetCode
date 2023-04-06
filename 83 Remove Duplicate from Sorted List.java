/*Solution: Recursivly call
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.val == head.val) {
            cur = cur.next;
        }

        head.next = deleteDuplicates(cur);
        return head;
    }
}