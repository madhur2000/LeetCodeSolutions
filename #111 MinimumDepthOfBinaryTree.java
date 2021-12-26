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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if(leftMinDepth < rightMinDepth && leftMinDepth != 0){
            return (leftMinDepth + 1);
        }
        if(leftMinDepth == 0)
            return (rightMinDepth + 1);
        if(rightMinDepth != 0)
            return (rightMinDepth + 1);
        return (leftMinDepth + 1);
    }
}
