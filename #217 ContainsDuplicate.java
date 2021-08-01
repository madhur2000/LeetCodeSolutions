class Solution {
    public boolean containsDuplicate(int[] nums) {
        
//         O(N)
        
        Set<Integer> hs = new HashSet<>();
        
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(!hs.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
