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
    private ListNode findKthNode(ListNode temp, int k){
        k-=1;
        while(temp!=null&&k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode;
        ListNode prev = null;

        while(temp!=null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                if(prev!=null) prev.next = temp;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
             ListNode reversed = reverse(temp);

            if(temp==head){
                head=reversed;
            }else{
                prev.next = reversed;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }
}