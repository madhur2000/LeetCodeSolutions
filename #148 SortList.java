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
    public ListNode sortList(ListNode head) {
        // int length = getListLength(head);
        // for(int i=0; i<length-1; i++){
        //     head = locate(head);
        // }
        // return head;
        
        if(head == null || head.next == null) return head;
        
        ListNode mid = getMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        
        ListNode ans = merge(left, right);
        return ans;
        
    }
    
    public static ListNode merge(ListNode left, ListNode right){
        
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        
        while(left != null && right != null){
            if(left.val > right.val){
                tail.next = new ListNode(right.val);
                right = right.next;
            }
            else{
                tail.next = new ListNode(left.val);
                left = left.next;
            }
            tail = tail.next;
        }
        
        while(right != null){
            tail.next = new ListNode(right.val);
            right = right.next;
            tail = tail.next;
        }
        
        while(left != null){
            tail.next = new ListNode(left.val);
            left = left.next;
            tail = tail.next;
        }
        return ans.next;
    }
    
    public static ListNode getMid(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }
    
//     public static ListNode locate(ListNode head){
//         if(head == null || head.next == null)
//             return head;
        
//         ListNode temp = head.next;
//         if(head.val > temp.val){
//             head.next = temp.next;
//             temp.next = head;
//             head = temp;
//         }
        
//         ListNode smallAns = locate(head.next);
        
//         head.next = smallAns;
//         return head;
//     }
    
//     public static int getListLength(ListNode head){
//         if(head == null) return 0;
//         ListNode temp = head;
//         int ans = 0;
//         while(temp != null){
//             ans++;
//             temp = temp.next;
//         }
//         return ans;
//     }
    
}
