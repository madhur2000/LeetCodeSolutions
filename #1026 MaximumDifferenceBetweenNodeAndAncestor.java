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
// class Pair{
//     int smallest;
//     int largest;
//     public Pair(int smallest, int largest){
//         this.smallest = smallest;
//         this.largest = largest;
//     }
// }
class Pair{
    int min;
    int max;
    public Pair(int smallest, int largest){
        min = smallest;
        max = largest;
    }
}
class Solution {
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        
        
//         Approach-1: O(N^2)
        
//         if(root == null) return Integer.MIN_VALUE;
        
//         int option1 = Integer.MIN_VALUE, option2 = Integer.MIN_VALUE;
        
//         // int leftSmallest = getSmallest(root.left);
//         // int leftLargest = getLargest(root.left);
//         // int rightSmallest = getSmallest(root.right);
//         // int rightLargest = getLargest(root.right);
        
//         Pair leftSmallestAndLargest = getSmallestAndLargest(root.left);
//         Pair rightSmallestAndLargest = getSmallestAndLargest(root.right);
        
//         int leftSmallest = leftSmallestAndLargest.smallest;
//         int leftLargest = leftSmallestAndLargest.largest;
//         int rightSmallest = rightSmallestAndLargest.smallest;
//         int rightLargest = rightSmallestAndLargest.largest;
        
//         if(root.left != null)
//             option1 = Math.max(Math.abs(root.val - leftSmallest),
//                                 Math.abs(root.val - leftLargest));
//         if(root.right != null)
//             option2 = Math.max(Math.abs(root.val - rightSmallest),
//                                 Math.abs(root.val - rightLargest));
//         int option3 = maxAncestorDiff(root.left);
//         int option4 = maxAncestorDiff(root.right);
        
//         return Math.max(Math.max(option1, option2), Math.max(option3, option4));
        
        
        
//         Approach-2: O(N)
        
        // int maxDiff = 0;
        helper(root);
        return maxDiff;
        
    }
    
    Pair helper(TreeNode root){
        if(root == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Pair leftPair = helper(root.left);
        Pair rightPair = helper(root.right);
        
//         int currMaxDiff = Math.max(Math.max(Math.abs(root.val - leftPair.min), Math.abs(root.val - rightPair.min)),
//                                 Math.max(Math.abs(root.val - leftPair.max), Math.abs(root.val - rightPair.max)));
        
        // maxDiff = Math.max(currMaxDiff, maxDiff);
        int max = Math.max(leftPair.max, Math.max(rightPair.max, root.val));
        int min = Math.min(leftPair.min, Math.min(rightPair.min, root.val));
        
        int currMaxDiff = Math.max(max - root.val, root.val - min);
        
        maxDiff = Math.max(maxDiff, currMaxDiff);
        
        return new Pair(min, max);
    }
    
//     static int getSmallest(TreeNode root){
//         if(root == null)
//             return Integer.MAX_VALUE;
//         int op1 = getSmallest(root.left);
//         int op2 = getSmallest(root.right);
//         int op3 = root.val;
//         return Math.min(Math.min(op1, op2), op3);
//     }
    
//     static int getLargest(TreeNode root){
//         if(root == null)
//             return Integer.MIN_VALUE;
//         int op1 = getLargest(root.left);
//         int op2 = getLargest(root.right);
//         int op3 = root.val;
//         return Math.max(Math.max(op1, op2), op3);
//     }
    
    
//     static Pair getSmallestAndLargest(TreeNode root){
//         if(root == null){
//             Pair ans = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
//             return ans;
//         }
        
//         Pair op1 = getSmallestAndLargest(root.left);
//         Pair op2 = getSmallestAndLargest(root.right);
//         int op3 = root.val;
        
//         int smallest = Math.min(op1.smallest, Math.min(op2.smallest, op3));
//         int largest = Math.max(op1.largest, Math.max(op2.largest, op3));
        
//         return new Pair(smallest, largest);
//     }
    
    
}
