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
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        
        int height = getHeight(root);
        
        return helper(root, height);
        
    }
    
    public static int helper(TreeNode root, int n){
        
        if(root == null) return 0;
        
        if(root.left == null && root.right == null && n == 1) return root.val;
        
        return helper(root.left, n-1) + helper(root.right, n-1);
        
    }
    
    public static int getHeight(TreeNode root){
        if(root == null) return 0;
        
        return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
    }
    
}
