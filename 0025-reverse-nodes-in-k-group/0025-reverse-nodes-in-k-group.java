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
    private void reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    private ListNode findKth(ListNode head, int k){
        k-=1;
        ListNode temp = head;
        while(k>0){
            k--;
            if(temp!=null)temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp =head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kth = findKth(temp, k);
            if(kth==null){
                if(prev!=null)prev.next = temp;
                break;
            }
            ListNode next = kth.next;
            kth.next = null;
            reverse(temp);
            if(temp==head){
                head = kth;
            }
            else{
                prev.next = kth;
            }
            prev = temp;
            temp = next;
        }
        return head;
    }
}