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

    
    ListNode head;
    
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int length = getLength(head);
        Random rand = new Random();
        int randomIndex = rand.nextInt(length);
        return getValueAtIndex(head, randomIndex);
    }
    
    private int getValueAtIndex(ListNode head, int index){
        ListNode temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    private int getLength(ListNode head){
        if(head == null) return 0;
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
