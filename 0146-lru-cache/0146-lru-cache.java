class LRUCache {

    public class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int k, int v){
            this.key = k;
            this.val = v;
            next = null;
            prev = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    HashMap<Integer, Node> map = new HashMap<>();

    int limit = 0;


    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node ans = map.get(key);
        if(!map.containsKey(key)){
            return -1;
        }
        map.remove(key);
        delNode(ans);
        addNode(ans);
        map.put(key, ans);
        return ans.val;
    }

    private void addNode(Node newNode){
        Node oldNext = head.next;
        head.next = newNode;
        oldNext.prev = newNode;
        newNode.next = oldNext;
        newNode.prev = head;
    }

    private void delNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            delNode(oldNode);
            map.remove(key);
        }

        if(map.size()==limit){
            map.remove(tail.prev.key);
            delNode(tail.prev);
        }

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