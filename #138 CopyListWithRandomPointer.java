/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        
//         Flop approach
        
//         if(head == null)
//             return null;
//         if(head.next == null){
//             Node head2 = new Node(head.val);
//             if(head.random == null){
//                 head2.random =  null;
//             }
//             else{
//                 head2.random = head2;
//             }
//             return head2;
//         }
        
//         Node smallAns = copyRandomList(head.next);
//         Node head2 = new Node(head.val);
//         head2.next = smallAns;
//         if(head.random == null){
//             head2.random = null;
//         }
//         else{
//             int count=0;
//             Node temp = head;
//             while(temp != head.random){
//                 count++;
//                 temp = temp.next;
//             }
//             temp = head2;
//             while(count-- > 0){
//                 temp = temp.next;
//             }
//             head2.random = temp;
//         }
//         return head2;
        
        
        if(head == null)
            return null;
        
        HashMap<Node, Node> hm = new HashMap<>();
        Node temp1 = head;
        Node head2 = new Node(-1);
        Node temp2 = head2;
        
        while(temp1 != null){
            temp2.next = new Node(temp1.val);
            temp2 = temp2.next;
            
            hm.put(temp1, temp2);
            temp1 = temp1.next;
        }
        
        temp1 = head;
        temp2 = head2.next;
        
        while(temp1 != null){
            if(temp1.random != null){
                temp2.random = hm.get(temp1.random);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return head2.next;
    }
}
