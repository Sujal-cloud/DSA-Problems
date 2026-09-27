class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;

        node.next.prev = node.prev;
    }

    private void insertAfterHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);

            remove(node);
            insertAfterHead(node);

            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            remove(node);
            insertAfterHead(node);
        }else{
            if(map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);

                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */