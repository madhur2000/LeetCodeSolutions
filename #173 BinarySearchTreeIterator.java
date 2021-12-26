/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode itr;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        itr = root;
    }
    
    public int next() {
        TreeNode poppedNode = stack.pop();
        int smallest = poppedNode.val;
        TreeNode t = poppedNode.right;
        while(t != null){
            stack.push(t);
            t = t.left;
        }
        return smallest;
    }
    
    public boolean hasNext() {
        if(stack.empty()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
