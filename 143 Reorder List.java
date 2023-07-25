/*Solution: Reverse + Find Mid + Inplace Merge
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //first, we find the mid node
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        //then reverse the midNode
        ListNode newHead = reverse(next);
        ListNode cur = head;
        ListNode curM = newHead;
        while (cur != null && curM != null) {
            ListNode nextN = cur.next;
            ListNode nextM = curM.next;
            cur.next = curM;
            curM.next = nextN;
            cur = nextN;
            curM = nextM;
        }
        return;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}