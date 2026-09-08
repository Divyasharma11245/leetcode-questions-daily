class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
       this.capacity = capacity;
       map = new HashMap<>(); 
       head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }

    private void addNode(Node node){
        Node currHeadNext = head.next;
        head.next = node;
        node.next = currHeadNext;
        currHeadNext.prev = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addNode(node);
        }else{
            if(map.size()==capacity){
                Node node = tail.prev;
                deleteNode(node);
                map.remove(node.key);
            }
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addNode(newNode);
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */