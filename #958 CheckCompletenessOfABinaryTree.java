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
    public boolean isCompleteTree(TreeNode root) {
        
//         Approach: while traversing level wise, when null node is encountered, it should be the last node that we ever see | Accepted | https://www.youtube.com/watch?v=j16cwbLEf9w (Nick White)
        
        if(root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                TreeNode node = q.remove();
                if(node == null){
                    return allAreNull(q);
                }
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true; //unreachable
    }
    
    public static boolean allAreNull(Queue<TreeNode> q){
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node != null) return false;
        }
        return true;
    }
    
}
