class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int k, int v){
            key = k;
            val = v;
            prev=next=null;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    HashMap<Integer, Node> map = new HashMap();

    private void addNode(Node newNode){
        Node oldNext = head.next;
        head.next = newNode;
        newNode.prev = head;
        oldNext.prev = newNode;
        newNode.next = oldNext;
    }
    
    private void delNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    int limit;

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        return -1;

        Node node = map.get(key);

        delNode(node);
        addNode(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            delNode(oldNode);
            map.remove(key);
        }
        if(map.size()==limit){
            Node lru = tail.prev;
            map.remove(lru.key);
            delNode(lru);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */