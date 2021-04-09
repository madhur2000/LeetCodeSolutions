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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        List<Integer> leftTraversal = inorderTraversal(root.left);
        List<Integer> rightTraversal = inorderTraversal(root.right);
        list.addAll(leftTraversal);
        list.add(root.val);
        list.addAll(rightTraversal);
        
        return list;
    }
}
