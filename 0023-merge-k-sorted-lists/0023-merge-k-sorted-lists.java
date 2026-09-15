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
    private ListNode merge(ListNode head, ListNode nextList){
        ListNode temp1 = head;
        ListNode temp2 = nextList;
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        while(temp1!=null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
        }
        while(temp2!=null){
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode newMerged = null;
        for(int i = 0; i<n; i++){
            newMerged = merge(newMerged, lists[i]);
        }
        return newMerged;
    }
}