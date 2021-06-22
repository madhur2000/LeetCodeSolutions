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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            List<Integer> al = new ArrayList<>();
            int n = q.size();
            
            while(n-- > 0){
                TreeNode removed = q.remove();
                if(removed != null){
                    al.add(removed.val);
                    if(removed.left != null)
                        q.add(removed.left);
                    if(removed.right != null)
                        q.add(removed.right);
                }
                else{
                    if(!q.isEmpty())
                        q.add(null);
                }
            }
            ans.add(al);
        }
        return ans;
    }
}
