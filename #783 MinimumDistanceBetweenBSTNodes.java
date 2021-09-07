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
    public int minDiffInBST(TreeNode root) {
        List<Integer> inTrav = getInorder(root);
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=1; i<inTrav.size(); i++){
            ans = Math.min(ans, inTrav.get(i) - inTrav.get(i-1));
        }
        
        return ans;
    }
    
    private static List<Integer> getInorder(TreeNode root){
        if(root == null)
            return new LinkedList<>();
        
        List<Integer> ans = new LinkedList<>();
        ans.addAll(getInorder(root.left));
        ans.add(root.val);
        ans.addAll(getInorder(root.right));
        
        return ans;
    }
}
