/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp !=null){
        size++;
        temp = temp.next;
        }

        temp = head;
        int mid = size/2;
        
        for(int i = 0; i<mid; i++){
            temp = temp.next;
        }
        return temp;

    }
}