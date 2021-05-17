class Solution {
    public int rob(int[] nums) {
        
//         if(nums.length == 1)
//             return nums[0];
        
//         int sum1=0, sum2=0;
        
//         for(int i=0; i<nums.length; i+=2){
//             sum1 += nums[i];
//         }
//         for(int j=1; j<nums.length; j+=2){
//             sum2 += nums[j];
//         }
//         return Math.max(sum1, sum2);
        
        // return helper(nums, 0, nums.length-1);
        
        int[][] storage = new int[nums.length][nums.length];
        // Arrays.fill(storage, -1);
        // for(int[] arr : storage){
        //     Arrays.fill(arr, -1);
        // }
        
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage[i].length; j++){
                storage[i][j] = -1;
            }
        }
        
        return robM(nums, 0, nums.length-1, storage);
        
//         if(start == end){
//             return nums[start];
//         }
//         int sum1 = nums[start];
//         sum1 += helper(nums, start+2, end);
        
//         int sum2 = nums[start+1];
//         sum2 += helper(nums, start+3, end);
        
//         return Math.max(sum1, sum2);
        
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
