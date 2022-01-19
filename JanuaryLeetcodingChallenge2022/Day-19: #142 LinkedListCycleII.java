/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        
//         Approach-1: HashSet
        
        // Set<ListNode> seenNodes = new HashSet<>();
        // ListNode temp = head;
        // while(temp != null){
        //     if(!seenNodes.add(temp)){
        //         return temp;
        //     }
        //     temp = temp.next;
        // }
        // return null;
        
        
        
//         Approach-2: Tortoise and Hare
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        int cycleLength = 1;
        fast = slow.next;
        while(slow != fast){
            cycleLength += 1;
            fast = fast.next;
        }
        
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i=0; i<cycleLength; i++){
            p2 = p2.next;
        }
        
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
