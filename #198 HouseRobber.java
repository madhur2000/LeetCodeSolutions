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






















// Revision Session:


// class Solution {
//     public int rob(int[] nums) {
//         // return robRecursive(nums, 0);
        
//         // return robRecursive2(nums, nums.length-1);
        
// //         Approach-2: (top-down DP)
        
// //         int[] storage = new int[nums.length+1];
// //         Arrays.fill(storage, -1);
        
// //         return robM(nums, nums.length-1, storage);
        
        
        
        
// //         Approach-3: (Bottom-up DP)
        
//         if(nums == null || nums.length == 0)
//             return 0;
        
//         if(nums.length == 1)
//             return nums[0];
        
//         int[] storage = new int[nums.length];
        
//         storage[0] = nums[0];
//         storage[1] = Math.max(nums[0], nums[1]);
        
        
//         for(int i=2; i<storage.length; i++){
            
//             storage[i] = Math.max(storage[i-1], storage[i-2] + nums[i]);
            
//         }
        
//         return storage[storage.length-1];
//     }
    
// //     public static int robRecursive(int[] nums, int start){
// //         if(start >= nums.length)
// //             return 0;
        
// //         int option1 = nums[start] + robRecursive(nums, start+2);
        
// //         int option2 = robRecursive(nums, start+1);
        
// //         return Math.max(option1, option2);
// //     }
    
// //     public static int robRecursive2(int[] nums, int end){
        
// //         if(end < 0)
// //             return 0;
        
// //         int option1 = robRecursive2(nums, end-1);
// //         int option2 = robRecursive2(nums, end-2) + nums[end];
        
// //         return Math.max(option1, option2);
        
// //     }
    
// //     public static int robM(int[] nums, int end, int[] storage){
        
// //         if(end < 0)
// //             return 0;
        
// //         if(end == 0){
// //             storage[end] = nums[end];
// //             return storage[end];
// //         }
        
// //         if(storage[end] != -1){
// //             return storage[end];
// //         }
        
// //         int sa1 = robM(nums, end-1, storage);
// //         int sa2 = robM(nums, end-2, storage);

// //         storage[end-1] = sa1;
// //         if(end-2 >= 0){
// //             storage[end-2] = sa2;
// //         }
// //         storage[end] = Math.max(sa1, sa2 + nums[end]);
// //         return storage[end];
// //     }
    
// }
