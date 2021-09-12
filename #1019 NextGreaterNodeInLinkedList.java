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
    public int[] nextLargerNodes(ListNode head) {
        
//         Approach-1: Brute Force
        
//         int[] ans = new int[getListLength(head)];
//         int index = 0;
//         ListNode temp = head;
//         // ListNode temp2 = head.next;
        
//         while(temp != null){
//             ListNode temp2 = temp.next;
//             while(temp2 != null){
//                 if(temp2.val > temp.val){
//                     ans[index++] = temp2.val;
//                     break;
//                 }
//                 temp2 = temp2.next;
//             }
//             if(temp2 == null)
//                 ans[index++] = 0;
//             temp = temp.next;
//         }
//         return ans;
        
        List<Integer> input = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            input.add(temp.val);
            temp = temp.next;
        }
        Deque<Integer> stack = new LinkedList<>();
        int[] output = new int[input.size()];
        for(int i=0; i<input.size(); i++){
            while(!stack.isEmpty() && input.get(i) > input.get(stack.peek())){
                output[stack.peek()] = input.get(i);
                stack.pop();
            }
            stack.push(i);
        }
        return output;
    }
    
    // private static int getListLength(ListNode head){
    //     ListNode temp = head;
    //     int length = 0;
    //     while(temp != null){
    //         length += 1;
    //         temp = temp.next;
    //     }
    //     return length;
    // }
    
}
