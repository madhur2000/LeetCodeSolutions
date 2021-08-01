class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        return helper(nums,0);
        
    }
    
    public static List<List<Integer>> helper(int[] nums, int start){
        if(start >= nums.length){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        
        List<List<Integer>> sa = helper(nums,start + 1);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(sa);
        
        for(List<Integer> al : sa){
            List<Integer> al2 = new ArrayList<>();
            al2.add(nums[start]);
            al2.addAll(al);
            ans.add(al2);
        }
        
        return ans;
    }
}
