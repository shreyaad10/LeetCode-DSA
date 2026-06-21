class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;

    private Node left;   // LRU dummy
    private Node right;  // MRU dummy

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node prevMRU = right.prev;

        prevMRU.next = node;
        node.prev = prevMRU;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);

        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {

            Node lru = left.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}