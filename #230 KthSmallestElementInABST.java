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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = getInOrderTraversal(root);
        
        return inOrder.get(k-1);
    }
    
    public static List<Integer> getInOrderTraversal(TreeNode root){
        if(root == null) return null;
        
        List<Integer> left = getInOrderTraversal(root.left);
        List<Integer> right = getInOrderTraversal(root.right);
        
        List<Integer> ans = new ArrayList<>();
        
        if(left != null)
            ans.addAll(left);
        
        ans.add(root.val);
        
        if(right != null)
            ans.addAll(right);
        
        return ans;
    }
    
}
