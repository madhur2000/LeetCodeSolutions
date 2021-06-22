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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
// //         Approach-1: ACCEPTED but not recommended
        
        
// //         Normal Level Order Traversal:
        
//         if(root == null){
//             return new ArrayList<>();
//         }
        
//         List<List<Integer>> ans = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         q.add(null);
        
//         while(!q.isEmpty()){
//             List<Integer> al = new ArrayList<>();
//             int n = q.size();
            
//             while(n-- > 0){
//                 TreeNode removed = q.remove();
//                 if(removed != null){
//                     al.add(removed.val);
//                     if(removed.left != null)
//                         q.add(removed.left);
//                     if(removed.right != null)
//                         q.add(removed.right);
//                 }
//                 else{
//                     if(!q.isEmpty())
//                         q.add(null);
//                 }
//             }
//             ans.add(al);
//         }
        
// //         Reversing lists at odd positions
        
//         for(int i=0; i<ans.size(); i++){
//             if((i & 1) != 0){
//                 List<Integer> al = ans.get(i);
//                 reverseList(al);
//             }
//         }
        
//         return ans;
        
        
//         Approach-2:
        
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        boolean isLevelOdd = true;
        
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> al = new ArrayList<>();
            while(n-- > 0){
                TreeNode removed = q.remove();
                if(isLevelOdd){
                    al.add(removed.val);
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(removed.val);
                    temp.addAll(al);
                    al.clear();
                    al.addAll(temp);
                }
                
                if(removed.left != null){
                    q.add(removed.left);
                }
                if(removed.right != null){
                    q.add(removed.right);
                }
            }
            ans.add(al);
            isLevelOdd = !isLevelOdd;
        }
        
        return ans;
        
        
    }
    
//     public static void reverseList(List<Integer> al){
        
//         int n = al.size();
        
//         int i=0, j = n-1;
        
//         while(i < j){
//             int temp = al.get(i);
//             al.set(i, al.get(j));
//             al.set(j, temp);
            
//             i++;
//             j--;
//         }
        
//     }
    
    
}
