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
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1 = head1;
        ListNode t2 = head2;
        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                temp.next = t1;
                t1 = t1.next;
                temp = temp.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
                temp=temp.next;
            }
        }
        if(t1!=null){
            temp.next = t1;
        }
        if(t2!=null){
            temp.next = t2;
        }
        return dummy.next;
        
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

    ListNode middle = findMiddle(head);
    ListNode leftHead = head;
    ListNode rightHead = middle.next;
    middle.next = null;;
    leftHead = sortList(leftHead);
    rightHead = sortList(rightHead);
    return merge(leftHead, rightHead);
    }
}