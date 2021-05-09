/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            Node popped = q.remove();
            if(popped != null){
                popped.next = q.peek();
                if(popped.left != null)
                    q.add(popped.left);
                
                if(popped.right != null)
                    q.add(popped.right);
            }
            else{
                if(!q.isEmpty())
                    q.add(null);
            }
        }
        return root;
    }
}
