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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        
//         if(root == Integer.MAX_VALUE){
            
//         }
        
        if(root.left == null && root.right == null)
            return true;
        
        if(root.left != null){
            int leftMax = findMax(root.left);
            if(leftMax >= root.val)
                return false;
        }
        
        if(root.right != null){
            int rightMin = findMin(root.right);
            if(rightMin <= root.val)
                return false;
        }
            
        boolean isLeftValid = isValidBST(root.left);
        boolean isRightValid = isValidBST(root.right);
        
        if(!isLeftValid || !isRightValid)
            return false;
        return true;
    }
    
    public static int findMax(TreeNode root){
        
        if(root == null)
            return Integer.MIN_VALUE;
        
        int maxLeft = findMax(root.left);
        int maxRight = findMax(root.right);
        
        return Math.max(maxLeft,Math.max(maxRight, root.val));
    }
    
    public static int findMin(TreeNode root){
        
        if(root == null)
            return Integer.MAX_VALUE;
        
        int minLeft = findMin(root.left);
        int minRight = findMin(root.right);
        
        return Math.min(minLeft,Math.min(minRight, root.val));
    }
    
}
