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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
//         Approach-1: Using HashSet
//         if(headA == null || headB == null){
//             return null;
//         }
        
//         ListNode temp = headA;
        
//         HashSet<ListNode> hs = new HashSet<>();
        
//         while(temp != null){
            
//             hs.add(temp);
//             temp = temp.next;
//         }
        
//         temp = headB;
        
//         while(temp != null){
            
//             if(hs.contains(temp)){
//                 return temp;
//             }
//             temp = temp.next;
//         }
//         return null;
        
        
//         Approach-2: two pointers
        
        if(headA == null || headB == null)
            return null;
        
        ListNode i = headA;
        ListNode j = headB;
        
        while(i != j){
            
            if(i == null){
                i = headB;
            }
            else{
                i = i.next;
            }
            if(j == null){
                j = headA;
            }
            else{
                j = j.next;
            }
            
        }
        
        return i;
    }
}
