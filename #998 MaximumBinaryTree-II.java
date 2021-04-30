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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        
        ArrayList<Integer> al = convertToArrayList(root);
        al.add(val);
        
        Integer[] arr = new Integer[al.size()];
        arr = al.toArray(arr);
        
        return constructMaximumBinaryTree(arr);
        
    }
    
    public static ArrayList<Integer> convertToArrayList(TreeNode root){
        
        if(root == null)
            return null;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        ArrayList<Integer> leftAns = convertToArrayList(root.left);
        
        if(leftAns != null)
            result.addAll(leftAns);
        
        result.add(root.val);
        
        ArrayList<Integer> rightAns = convertToArrayList(root.right);
        
        if(rightAns != null)
            result.addAll(rightAns);
        
        return result;
    }
    
    
    public TreeNode constructMaximumBinaryTree(Integer[] nums) {
        
        return helper(nums, 0, nums.length-1);
        
    }
    
    public static TreeNode helper(Integer[] nums, int start, int end){
        
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        
        for(int i=start; i<=end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        
        if(maxIndex == -1){
            return null;
        }
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex-1);
        root.right = helper(nums, maxIndex+1, end);
        
        return root;
        
    }
    
}
