class LFUCache {
    class Node{
        int key, val, cnt;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }

    class List{
        int size;
        Node head;
        Node tail;

        List(){
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        private void addNode(Node node){
        Node old = head.next;
        node.next = old;
        old.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }

    public void deleteNode(Node node){
        Node Old = node.next;
        Node Prev = node.prev;
        Old.prev = Prev;
        Prev.next = Old;
        size--;
    }
    }

    

    HashMap<Integer, Node> keyNode = new HashMap<>();
    HashMap<Integer, List> freqMap = new HashMap<>();
    int maxSize;
    int currSize;
    int minFreq;

    public LFUCache(int capacity) {
        keyNode = new HashMap<>();
        freqMap = new HashMap<>();
        maxSize = capacity;
        currSize = 0;
        minFreq = 0;
    }
    public void updateFreqMap(Node node){
        keyNode.remove(node.key);
        freqMap.get(node.cnt).deleteNode(node);
        if(node.cnt == minFreq&&freqMap.get(node.cnt).size==0){
            minFreq++;
        }
        List newList = new List();
        if(freqMap.containsKey(node.cnt+1)){
            newList = freqMap.get(node.cnt+1);
        }
        node.cnt+=1;
        newList.addNode(node);
        freqMap.put(node.cnt, newList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
       if(keyNode.containsKey(key)){
        Node node = keyNode.get(key);
        int val = node.val;
        updateFreqMap(node);
        return val;
       } 
       return -1;
    }
    
    public void put(int key, int value) {
        if(maxSize==0) return;
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.val = value;
            updateFreqMap(node);
        }else{
            if(currSize==maxSize){
                List list = freqMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                freqMap.get(minFreq).deleteNode(list.tail.prev);
                currSize--;
            }
            currSize++;
            minFreq = 1;
            List list = new List();
            if(freqMap.containsKey(minFreq)){
                list=freqMap.get(minFreq);
            }
            Node node = new Node(key, value);
            list.addNode(node);
            keyNode.put(key, node);
            freqMap.put(minFreq, list);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */