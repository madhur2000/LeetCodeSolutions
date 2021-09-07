class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        
        if(((sum+target)&1) != 0){
            return 0;
        }
        
        return subsetSum(nums, (sum+target)/2);
    }
    
    private static int subsetSum(int[] nums, int target){
        int[][] storage = new int[nums.length+1][Math.abs(target)+1];
        storage[0][0] = 1;
        for(int i=1; i<storage.length; i++){
            if(nums[i-1] == 0){
                storage[i][0] = storage[i-1][0] * 2;
            }
            else{
                storage[i][0] = storage[i-1][0];
            }
        }
        for(int i=1; i<storage[0].length; i++){
            storage[0][i] = 0;
        }
        
        for(int i=1; i<storage.length; i++){
            for(int j=1; j<storage[0].length; j++){
                if((j - nums[i-1]) >= 0){
                    storage[i][j] = storage[i-1][j] + storage[i-1][j - nums[i-1]];
                }
                else{
                    storage[i][j] = storage[i-1][j];
                }
            }
        }
        return storage[nums.length][Math.abs(target)];
    }
}
