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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        
        if(root.val >= low && root.val <= high){
            TreeNode ans = new TreeNode(root.val);
            ans.left = trimBST(root.left, low, high);
            ans.right = trimBST(root.right, low, high);
            return ans;
        }
        
        if(root.val < low)
            return trimBST(root.right, low, high);
        
        return trimBST(root.left, low, high);
    }
}
