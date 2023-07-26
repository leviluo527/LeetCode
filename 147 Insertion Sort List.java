/*Solution: Use Dummy Node
* Time: O(N^2)
* Space: O(N)
*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode curD = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            insert(cur, dummy);
            cur = next;
        }
        return dummy.next;
    }

    private void insert(ListNode cur, ListNode dummy) {
        ListNode curD = dummy;
        while (curD.next != null && curD.next.val < cur.val) {
            curD = curD.next;
        }
        ListNode next = curD.next;
        curD.next = cur;
        cur.next = next;
    }
}