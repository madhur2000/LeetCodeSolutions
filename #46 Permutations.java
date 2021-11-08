class Solution {
    public List<List<Integer>> permute(int[] nums) {
//         Approach-1: Simple Recursion
//         if(nums.length == 1){
//             List<List<Integer>> ans = new LinkedList<>();
//             List<Integer> list = new LinkedList<>();
//             list.add(nums[0]);
//             ans.add(list);
//             return ans;
//         }
        
//         List<List<Integer>> ans = new LinkedList<>();
        
//         for(int i=0; i<nums.length; i++){
//             int[] a = new int[nums.length-1];
//             int g=0;
//             for(int j=0; j<i; j++){
//                 a[g++] = nums[j];
//             }
//             for(int j=i+1; j<nums.length; j++){
//                 a[g++] = nums[j];
//             }
            
//             List<List<Integer>> sa = permute(a);
//             for(List<Integer> list : sa){
//                 list.add(0, nums[i]);
//             }
//             ans.addAll(sa);
//         }
//         return ans;
        
//         Approach-2: Backtracking
        
        List<Integer> currPermutation = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        helper(nums, ans, currPermutation, visited);
        return ans;
    }
    
    void helper(int[] nums, List<List<Integer>> ans, List<Integer> currList, boolean[] visited){
        if(currList.size() == nums.length){
            ans.add(new ArrayList(currList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                currList.add(nums[i]);
                helper(nums, ans, currList, visited);
                visited[i] = false;
                currList.remove(currList.size()-1);
            }
        }
    }
    
}
