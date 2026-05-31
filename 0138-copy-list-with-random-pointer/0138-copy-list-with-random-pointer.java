/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node, Node> m = new HashMap<>();
        Node newHead = new Node(head.val);
        Node oldTemp = head.next;
        Node newTemp = newHead;

        m.put(head, newHead);

        while(oldTemp!=null){
            Node copyNode = new Node(oldTemp.val);
            m.put(oldTemp, copyNode);
            newTemp.next = copyNode;

            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }

        oldTemp = head;
        newTemp = newHead;
        while(oldTemp!=null){
            newTemp.random = m.get(oldTemp.random);

            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }
        return newHead;
    }
}