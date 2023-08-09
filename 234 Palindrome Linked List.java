/*Solution: Reverse second half to make the space O(1)
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode nextHead = reverse(next);
        ListNode curH = head;
        ListNode curN = nextHead;
        while (curH != null && curN != null) {
            if (curH.val != nextHead.val) {
                return false;
            }
            curH = curH.next;
            curN = curN.next;
        }
        return true;
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