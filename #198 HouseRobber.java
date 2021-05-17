class Solution {
    public int rob(int[] nums) {
        
//         Approach-2: Memoization
//         int[][] storage = new int[nums.length][nums.length];
//         for(int[] arr : storage){
//             Arrays.fill(arr, -1);
//         }
        
//         return robM(nums, 0, nums.length-1, storage);
        
//         Approach-1: Recursion
        
//         if(start == end){
//             return nums[start];
//         }
//         int sum1 = nums[start];
//         sum1 += helper(nums, start+2, end);
        
//         int sum2 = nums[start+1];
//         sum2 += helper(nums, start+3, end);
        
//         return Math.max(sum1, sum2);
        
        
        
//         Approach-3: DP
        
        int[] storage = new int[nums.length+1];
        storage[0] = 0;
        storage[1] = nums[0];
        
        for(int i=2; i<storage.length; i++){
            
            storage[i] = Math.max(storage[i-1], storage[i-2] + nums[i-1]);
            
        }
        return storage[nums.length];
        
    }
    
//     public static int helper(int[] nums, int start, int end){
        
//         if(start > end)
//             return 0;
        
//         if(start == end){
//             return nums[start];
//         }
//         int sum1 = nums[start];
//         sum1 += helper(nums, start+2, end);
        
//         int sum2 = nums[start+1];
//         sum2 += helper(nums, start+3, end);
        
//         return Math.max(sum1, sum2);
//     }
    
    
    public static int robM(int[] nums, int start, int end, int[][] storage){
        
        if(start > end){
            return 0;
        }
        
        if(start == end){
            storage[start][end] = nums[start];
            return storage[start][end];
        }
        
        if(storage[start][end] != -1){
            return storage[start][end];
        }
        
        int sum1 = nums[start];
        int sa1 = robM(nums, start+2, end, storage);
        if(start+2 <= end)
            storage[start+2][end] = sa1;
        
        sum1 += sa1;
        
        int sum2 = nums[start+1];
        int sa2 = robM(nums, start+3, end, storage);
        if(start+3 <= end)
            storage[start+3][end] = sa2;
        
        sum2 += sa2;
        
        storage[start][end] = Math.max(sum1, sum2);
        
        return storage[start][end];
    }
    
}
