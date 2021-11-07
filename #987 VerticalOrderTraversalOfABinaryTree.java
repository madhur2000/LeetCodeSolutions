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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer col : map.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> map2 = map.get(col);
            List<Integer> list = new ArrayList<>();
            for(Integer row : map2.keySet()){
                PriorityQueue<Integer> set = map2.get(row);
                // list.addAll(set);
                while(!set.isEmpty()){
                    list.add(set.remove());
                }
            }
            ans.add(list);
        }
        return ans;
    }
    
    static void helper(TreeNode root, int row, int col, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(root == null) return;
        if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());
        }
        if(!map.get(col).containsKey(row)){
            PriorityQueue<Integer> set = new PriorityQueue<>();
            set.add(root.val);
            map.get(col).put(row, set);
        } else{
            PriorityQueue<Integer> set = map.get(col).get(row);
            set.add(root.val);
        }
        helper(root.left, row+1, col-1, map);
        helper(root.right, row+1, col+1, map);
    }
    
}
