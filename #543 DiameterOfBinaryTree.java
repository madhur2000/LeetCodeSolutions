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

class Pair{
    int height;
    int diameter;
    public Pair(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
//         if(root == null)
//             return 0;
        
//         int leftHeight = getHeight(root.left);
//         int rightHeight = getHeight(root.right);
        
//         int op1 = leftHeight + rightHeight;
//         int op2 = diameterOfBinaryTree(root.left);
//         int op3 = diameterOfBinaryTree(root.right);
        
//         return Math.max(op1, Math.max(op2, op3));
        
        return helper(root).diameter;
    }
    
    private static Pair helper(TreeNode root){
        if(root == null)
            return new Pair(0, 0);
        
        Pair leftAns = helper(root.left);
        Pair rightAns = helper(root.right);
        
        int op1 = leftAns.height + rightAns.height;
        int op2 = leftAns.diameter;
        int op3 = rightAns.diameter;
        
        int diameter = Math.max(op1, Math.max(op2, op3));
        int height = Math.max(leftAns.height, rightAns.height) + 1;
        
        return new Pair(height, diameter);
    }
    
//     private static int getHeight(TreeNode root){
//         if(root == null) return 0;
        
//         return (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
//     }
}
