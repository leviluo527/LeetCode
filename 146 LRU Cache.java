/*Solution: Use Doubly List Node + HashMap, OOD
* Time: O(1)
* Space: O(capacity)
*/
class LRUCache {
    private DNode head;
    private DNode tail;
    private int size;
    private int capacity;
    //key + DNode pair
    private Map<Integer, DNode> map;

    public LRUCache(int capacity) {
        head = new DNode();
        tail = new DNode();
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();    
    }
    
    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(DNode node) {
        DNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void removeNode(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    //we return DNode on this function, since we need to remove the KV in map
    private DNode popTail() {
        DNode cur = tail.prev;
        removeNode(cur);
        return cur;
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            res = map.get(key).val;
            moveToHead(map.get(key));
        }
        return res;
    }
    
    public void put(int key, int value) {
        DNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            size++;
            if (size > capacity) {
                DNode cur = popTail();
                map.remove(cur.key);
                size--;
            }
            node = new DNode();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addNode(node);
        }
    }
}

class DNode {
    DNode prev;
    DNode next;
    int key;
    int val;
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */