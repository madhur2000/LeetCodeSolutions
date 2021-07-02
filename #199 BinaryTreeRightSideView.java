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
    public List<Integer> rightSideView(TreeNode root) {
        
        
//         Approach: Last element of every level in Level Order Traversal | O(N) | ACCEPTED
        
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> levelOrder = getLevelOrderTraversal(root);
        
        for(int i=0; i<levelOrder.size(); i++){
            
            ans.add(levelOrder.get(i).get(levelOrder.get(i).size()-1));
            
        }
        return ans;
    }
    
    public static List<List<Integer>> getLevelOrderTraversal(TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> al = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = q.remove();
                al.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            ans.add(al);
        }
        return ans;
    }
    
}
