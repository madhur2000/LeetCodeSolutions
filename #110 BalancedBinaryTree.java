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
    boolean isBalanced;
    public Pair(int height, boolean isBalanced){
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private static Pair helper(TreeNode root){
        if(root == null)
            return new Pair(0, true);
        
        Pair leftAns = helper(root.left);
        Pair rightAns = helper(root.right);
        
        if(Math.abs(leftAns.height - rightAns.height) > 1
            || !leftAns.isBalanced || !rightAns.isBalanced){
            return new Pair(Math.max(leftAns.height, rightAns.height)+1, false);
        }
        
        Pair ans = new Pair(Math.max(leftAns.height, rightAns.height)+1, true);
        return ans;
    }
}
