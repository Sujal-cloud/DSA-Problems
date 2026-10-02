class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLL {
    Node head;
    Node tail;

    DLL() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void addFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    Node removeLRU() {
        if (head.next == tail) {
            return null;
        }

        Node node = tail.prev;
        remove(node);

        return node;
    }

    boolean isEmpty() {
        return head.next == tail;
    }
}


class LFUCache {

    int capacity;
    int minFreq;

    Map<Integer, DLL> freqMap;
    Map<Integer, Node> cacheMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        freqMap = new HashMap<>();
        cacheMap = new HashMap<>();
    }

    void increaseFreq(Node node) {

        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());

        newList.addFront(node);

        freqMap.put(node.freq, newList);
    }

    public int get(int key) {

        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        Node node = cacheMap.get(key);

        increaseFreq(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (cacheMap.containsKey(key)) {

            Node node = cacheMap.get(key);

            node.val = value;

            increaseFreq(node);

            return;
        }

        // Cache is full
        if (cacheMap.size() == capacity) {

            DLL list = freqMap.get(minFreq);

            Node lru = list.removeLRU();

            cacheMap.remove(lru.key);
        }

        // Create new node
        Node node = new Node(key, value);

        cacheMap.put(key, node);

        DLL list = freqMap.getOrDefault(1, new DLL());

        list.addFront(node);

        freqMap.put(1, list);

        minFreq = 1;
    }
}