/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int getSize(ListNode head){
        int count = 0;

        if(head==null){
            return 0;
        }

        if(head.next==null){
            return 1;
        }
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        while(sizeA>sizeB){
            sizeA--;
            headA = headA.next;
        }

        while(sizeB>sizeA){
            sizeB--;
            headB = headB.next;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}