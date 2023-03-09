/*Solution: Use getLength + find Kth Node
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //base case
        if (k == 0 || head == null) {
            return head;
        }
        int length = getLen(head);
        k %= length;
        
        if (k == 0) {
            return head;
        }
        k = length - k;
        ListNode kthNode = findKth(head, k);
        ListNode curHead = kthNode.next;
        kthNode.next = null;
        ListNode cur = curHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return curHead;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    private ListNode findKth(ListNode head, int k) {
        ListNode cur = head;
        while (k > 1) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}