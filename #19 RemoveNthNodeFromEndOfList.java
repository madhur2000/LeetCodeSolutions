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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null) return null;
        if(head.next == null){
            if(n == 1) return null;
            else return head;
        }
        
        int length = getLength(head);
        
        int m = length - n;
        
        if(m == 0){
            head = head.next;
            return head;
        }
        
        m = m-1;
        
        ListNode temp = head;
        
        while(m-- > 0){
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        
        return head;
        
    }
    
    public static int getLength(ListNode head){
        if(head == null) return 0;
        
        int length = 0;
        
        ListNode temp = head;
        
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    
}
