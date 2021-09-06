class Solution {
    public boolean canPartition(int[] nums) {
//         Approach-1: Recursion
        // return helper(nums, 0, 0, 0);
        
        
//         Approach-2: using Subset Sum Problem
        
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        
        if((sum&1) != 0)
            return false;
        
        return subsetSum(nums, sum/2);
    }
    
    private static boolean subsetSum(int[] nums, int sum){
        boolean[][] storage = new boolean[nums.length+1][sum+1];
        storage[0][0] = true;
        for(int i=1; i<storage.length; i++){
            storage[i][0] = true;
        }
        for(int i=1; i<storage[0].length; i++){
            storage[0][i] = false;
        }
        
        for(int i=1; i<storage.length; i++){
            for(int j=1; j<storage[0].length; j++){
                if(j-nums[i-1] >= 0){
                    storage[i][j] = storage[i-1][j] || storage[i-1][j-nums[i-1]];
                }
                else{
                    storage[i][j] = storage[i-1][j];
                }
            }
        }
        
        return storage[nums.length][sum];
    }
    
//     public static boolean helper(int[] nums, int start, int sum1, int sum2){
//         if(start == nums.length && sum1 == sum2)
//             return true;
//         if(start == nums.length){
//             return false;
//         }
        
//         return (helper(nums, start+1, sum1, sum2+nums[start])
//             || helper(nums, start+1, sum1+nums[start], sum2));
//     }
}
