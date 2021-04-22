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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null){
            if(root.val == 0)
                return null;
            return root;
        }
        if(root.val == 0){
            boolean onePresentInLeftSubtree = isOnePresent(root.left);
            boolean onePresentInRightSubtree = isOnePresent(root.right);
            if(!onePresentInLeftSubtree && !onePresentInRightSubtree){
                return null;
            }
            if(!onePresentInLeftSubtree){
                root.left = null;
            }
            if(!onePresentInRightSubtree){
                root.right = null;
            }
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        return root;
    }
    
    public static boolean isOnePresent(TreeNode root){
        
        if(root == null)
            return false;
        if(root.val == 1)
            return true;
        return (isOnePresent(root.left) || isOnePresent(root.right));
    }
    
}
