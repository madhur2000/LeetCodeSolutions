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
    public boolean isPalindrome(ListNode head) {
        
//         if(head == null || head.next == null)
//             return true;
        
//         ListNode temp = head;
        
//         while(temp.next.next != null){
//             temp = temp.next;
//         }
        
//         if(head.val != temp.next.val){
//             return false;
//         }
        
//         temp.next = null;
        
//         if(isPalindrome(head.next))
//             return true;
//         return false;
        
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        ListNode temp = head;
        int length = 0;
        
        while(temp != null){
            length++;
            temp = temp.next;
        }
        
        ListNode mid = head;
        
        if((length & 1) != 0){
            for(int i=0; i<length/2; i++){
                mid = mid.next;
            }
        }
        else{
            mid = null;
        }
        
        
        temp = head;
        
        while(temp != null){
            if(temp != mid){
                if(st.isEmpty() || st.peek() != temp.val){
                    st.push(temp.val);
                }
                else{
                    st.pop();
                }
            }
            temp = temp.next;
        }
        
        return (st.isEmpty()) ? true : false;
        
    }
}
