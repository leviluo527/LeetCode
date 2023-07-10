/*Solution: each time find the mid node, then split the left and right
* Time: O(N)
* Space: O(logN)
*/
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode leftTail = findMid(head);
        ListNode mid = leftTail.next;
        ListNode right = mid.next;
        //remember to cut the left tail
        leftTail.next = null;
        mid.next = null;
        TreeNode cur = new TreeNode(mid.val);
        cur.left = sortedListToBST(head);
        cur.right = sortedListToBST(right);
        return cur;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}