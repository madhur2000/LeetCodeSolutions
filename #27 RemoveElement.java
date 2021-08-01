class Solution {
    public int removeElement(int[] nums, int val) {
        
//         Approach-1: Recursive | O(N^2)
        // return helper(nums, 0, val);
        
//         Approach-2: O(N)
        
        int g=0;
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] != val){
                nums[g++] = nums[i];
            }
        }
        return g;
    }
    
//     public static int helper(int[] nums, int start, int val){
        
//         if(start >= nums.length)
//             return 0;
        
//         if(nums[start] == val){
//             int sa = helper(nums, start+1, val);
//             for(int i=start+1; i<nums.length; i++){
//                 nums[i-1] = nums[i];
//             }
//             return sa;
//         }
//         return (helper(nums, start+1, val) + 1);
//     }
}
