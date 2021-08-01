class Solution {
    public void moveZeroes(int[] nums) {
        
        Approach-1: O(N)
        
        int g=0;
        
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                nums[g++] = nums[i];
            }
        }
        
        for(int i=g; i<n; i++){
            nums[i] = 0;
        }
        
    }
}
