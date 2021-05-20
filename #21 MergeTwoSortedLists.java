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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode l1_temp = l1;
        ListNode l2_temp = l2;
        
        ListNode result = new ListNode(0);
        ListNode tail = result;
        
        while(l1_temp != null && l2_temp != null){
            
            if(l1_temp.val <= l2_temp.val){
                tail.next = l1_temp;
                l1_temp = l1_temp.next;
            }
            else{
                tail.next = l2_temp;
                l2_temp = l2_temp.next;
            }
            tail = tail.next;
            
        }
        
        if(l1_temp == null){
            tail.next = l2_temp;
        }
        
        if(l2_temp == null){
            tail.next = l1_temp;
        }
        return result.next;
    }
}
