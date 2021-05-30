/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//         Approach-1: works fine but not recommended (Reason: more time complexity)
//         if(root.val == p.val || root.val == q.val)
//             return root;
        
//         boolean is_p_in_left = search(root.left, p);
//         boolean is_q_in_right = search(root.right, q);
        
//         if(is_p_in_left && is_q_in_right)
//             return root;
        
//         boolean is_q_in_left = search(root.left, q);
        
//         boolean is_p_in_right = search(root.right, p);
        
//         if(is_q_in_left && is_p_in_right)
//             return root;
        
//         if(is_p_in_left && is_q_in_left)
//             return lowestCommonAncestor(root.left, p, q);
        
//         return lowestCommonAncestor(root.right, p, q);
        
        
//         Approach-2: Very intriguing and the best
        
        if(root == null)
            return null;
        
        if(root.val == p.val || root.val == q.val)
            return root;
        
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        
        if(leftAns != null && rightAns != null){
            return root;
        }
        
        if(leftAns != null)
            return leftAns;
        
        return rightAns;
        
    }
    
    
    public static boolean search(TreeNode root, TreeNode p){
        
        if(root == null)
            return false;
        
        if(p.val == root.val)
            return true;
        
        if(search(root.left, p))
            return true;
        
        if(search(root.right, p))
            return true;
        
        return false;
        
    }
    
    
}
