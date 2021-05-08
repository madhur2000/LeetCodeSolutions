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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
//         ListNode temp = l1;
//         String l1_string = "";
//         while(temp != null){
//             l1_string += temp.val;
//             temp = temp.next;
//         }
        
//         temp = l2;
//         String l2_string = "";
//         while(temp != null){
//             l2_string += temp.val;
//             temp = temp.next;
//         }
        
//         StringBuilder sb = new StringBuilder();
//         sb.append(l1_string);
//         sb.reverse();
        
//         long l1_long = Long.parseLong(sb.toString());
        
//         sb = new StringBuilder();
//         sb.append(l2_string);
//         sb.reverse();
        
//         long l2_long = Long.parseLong(sb.toString());
        
//         long l3_long = l1_long + l2_long;
        
//         String l3_string = l3_long + "";
//         ListNode l3 = null;
//         temp = l3;
        
//         for(int i=l3_string.length()-1; i>=0; i--){
            
//             if(temp == null){
//                 temp = new ListNode(Integer.parseInt(l3_string.charAt(i) + ""));
//                 l3 = temp;
//             }
//             else{
//                 temp.next = new ListNode(Integer.parseInt(l3_string.charAt(i) + ""));
//                 temp = temp.next;
//             }
//         }
     
//         return l3;
        
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            
            int sum=0;
            
            if(l1 != null)
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;
            
            sum += carry;
            
            int x1 = sum % 10;
            int x2 = sum / 10;
            
            temp.next = new ListNode(x1);
            temp = temp.next;
            
            carry = x2;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            
        }
        
        return ans.next;
        
    }
}
