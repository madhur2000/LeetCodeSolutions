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
        
//         Approach-1: gives TLE [O(N^2)]
        
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
        
        
        
//         Approach-2: Accepted [O(N)] (uses stack)
        
//         ArrayDeque<Integer> st = new ArrayDeque<>();
        
//         ListNode temp = head;
//         int length = 0;
        
//         while(temp != null){
//             length++;
//             temp = temp.next;
//         }
        
//         ListNode mid = head;
        
//         if((length & 1) != 0){
//             for(int i=0; i<length/2; i++){
//                 mid = mid.next;
//             }
//         }
//         else{
//             mid = null;
//         }
        
        
//         temp = head;
        
//         while(temp != null){
//             if(temp != mid){
//                 if(st.isEmpty() || st.peek() != temp.val){
//                     st.push(temp.val);
//                 }
//                 else{
//                     st.pop();
//                 }
//             }
//             temp = temp.next;
//         }
        
//         return (st.isEmpty()) ? true : false;
     
        
//         Approach-3: reverse the list starting from mid
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode head2_rev = reverseListIteratve(head2);
        
        while(head2_rev != null){
            
            if(head.val == head2_rev.val){
                head = head.next;
                head2_rev = head2_rev.next;
            }
            else{
                return false;
            }
            
        }
        
        return true;
    }
    
    
//     public static ListNode reverseListRecursive(ListNode head){
        
//         if(head == null || head.next == null)
//             return head;
        
//         ListNode smallAns = reverseListRecursive(head.next);
        
//         ListNode smallAnsTail = head.next;
        
//         head.next = null;
        
//         smallAnsTail.next = head;
        
//         return smallAns;
        
//     }
    
    public static ListNode reverseListIteratve(ListNode head){
        
        if(head == null)
            return null;
        
        ListNode prev = null, curr = head, next = head.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
    
    
}
