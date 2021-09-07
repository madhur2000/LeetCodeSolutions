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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = root.val;
        int maxSumLevel = 1;
        int currLevel = 0;
        while(!q.isEmpty()){
            currLevel += 1;
            int n = q.size();
            int currLevelSum = 0;
            while(n-- > 0){
                TreeNode node = q.remove();
                currLevelSum += node.val;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(currLevelSum > maxSum){
                maxSum = currLevelSum;
                maxSumLevel = currLevel;
            }
        }
        return maxSumLevel;
    }
}
