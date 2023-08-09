/*Solution: It's delete the val, not delete the node
* Time: O(1)
* Space: O(1)
*/
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}