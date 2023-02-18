/*Solution: Use a dummy node
* Time: O(Max(l1, l2))
* Space: O(Max(l1, l2))
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int count = 0;
        while (l1 != null || l2 != null || count != 0) {
            int curVal = 0;
            if (l1 != null) {
                curVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curVal += l2.val;
                l2 = l2.next;
            }
            curVal += count;
            count = curVal / 10;
            curVal %= 10;
            cur.next = new ListNode(curVal);
            cur = cur.next;
        }
        return dummy.next;
    }
}