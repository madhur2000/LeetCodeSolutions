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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        
    }
    
    public static TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        
        if(prestart > preend) return null;
        
        if(prestart == preend){
            TreeNode root = new TreeNode(preorder[prestart]);
            return root;
        }
        
        TreeNode root = new TreeNode(preorder[prestart]);
        
        int index = search(inorder, preorder[prestart], instart, inend);
        int leftLength = index - instart;
        
        TreeNode leftAns = helper(preorder, prestart+1, prestart+leftLength, inorder, instart, index-1);
        TreeNode rightAns = helper(preorder, prestart+leftLength+1, preend, inorder, index+1, inend);
        
        root.left = leftAns;
        root.right = rightAns;
        
        return root;
        
    }
    
    public static int search(int[] inorder, int target, int start, int end){
        
        for(int i=start; i<=end; i++){
            if(inorder[i] == target)
                return i;
        }
        return -1;
    }
    
}
