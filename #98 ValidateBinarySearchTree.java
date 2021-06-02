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














// Revision Session: (The best solution ahead)


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

class Triplet{
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    boolean isBST = false;
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    
    public static Triplet helper(TreeNode root){
        
        if(root == null){
            Triplet ans = new Triplet();
            ans.max = Integer.MIN_VALUE;
            ans.min = Integer.MAX_VALUE;
            ans.isBST = true;
            return ans;
        }
        
        Triplet leftAns = helper(root.left);
        Triplet rightAns = helper(root.right);
        
        if((root.left != null && leftAns.max >= root.val) 
            || (root.right != null && rightAns.min <= root.val)){
            Triplet ans = new Triplet();
            ans.max = Math.max(root.val, Math.max(leftAns.max, rightAns.max));
            ans.min = Math.min(root.val, Math.min(leftAns.min, rightAns.min));
            ans.isBST = false;
            return ans;
        }
        
        if(leftAns.isBST && rightAns.isBST){
            Triplet ans = new Triplet();
            ans.max = Math.max(root.val, Math.max(leftAns.max, rightAns.max));
            ans.min = Math.min(root.val, Math.min(leftAns.min, rightAns.min));
            ans.isBST = true;
            return ans;
        }
        
        Triplet ans = new Triplet();
        ans.max = Math.max(root.val, Math.max(leftAns.max, rightAns.max));
        ans.min = Math.min(root.val, Math.min(leftAns.min, rightAns.min));
        ans.isBST = false;
        return ans;
        
    }
    
}








