class Solution {
    public int maxProduct(int[] nums) {
        
//         Approach-1: gives memory limit exceeded!
        
//         int[][] storage = new int[nums.length][nums.length];
        
//         for(int i=0; i<nums.length; i++){
//             for(int j=i; j<nums.length; j++){
                
//                 if(j == i){
//                     storage[i][j] = nums[j];
//                 }
//                 else{
//                     storage[i][j] = storage[i][j-1] * nums[j];
//                 }
                
//             }
//         }
        
//         int max = Integer.MIN_VALUE;
        
//         for(int i=0; i<storage.length; i++){
//             for(int j=i; j<storage[i].length; j++){
//                 if(max < storage[i][j]){
//                     max = storage[i][j];
//                 }
//             }
//         }
//         return max;
        
        
//         Approach-2: Memoizatioon (memory limit exceeded!)
        
//         int[][] storage = new int[nums.length][nums.length];
//         for(int i=0; i<storage.length; i++){
//             for(int j=0; j<storage[i].length; j++){
//                 storage[i][j] = Integer.MIN_VALUE;
//             }
//         }
        
//         return maxProduct(nums, 0, nums.length-1, storage);
        
//         Approach-3: learnt on YouTube
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        max[0] = nums[0];
        min[0] = nums[0];
        
        for(int i=1; i<nums.length; i++){
            
            if(nums[i] == 0){
                max[i] = 1;
                min[i] = 1;
            }
            else{
                int v1 = max[i-1] * nums[i];
                int v2 = min[i-1] * nums[i];
                
                max[i] = Math.max(nums[i], Math.max(v1, v2));
                min[i] = Math.min(nums[i], Math.min(v1, v2));
                
            }
            
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<max.length; i++){
            if(ans < max[i]){
                ans = max[i];
                if(ans == 1 && nums[i] == 0){
                    ans = 0;
                }
            }
        }
        return ans;
    }
    
    
//     public static int maxProduct(int[] nums, int start, int end, int[][] storage){
        
//         if(start == end){
//             storage[start][end] = nums[start];
//             return storage[start][end];
//         }
        
//         if(storage[start][end] != Integer.MIN_VALUE)
//             return storage[start][end];
        
//         int smallAns1;
        
//         if(storage[start][end-1] != Integer.MIN_VALUE)
//             smallAns1 = storage[start][end-1];
//         else{
//             smallAns1 = maxProduct(nums, start, end-1, storage);
//         }
        
//         int smallAns2;
//         if(storage[start+1][end] != Integer.MIN_VALUE){
//             smallAns2 = storage[start+1][end];
//         }
//         else{
//             smallAns2 = maxProduct(nums, start+1, end, storage);
//         }
//         int p=1;
        
//         for(int i=start; i<=end; i++){
//             p = p * nums[i];
//         }
        
//         storage[start][end] = Math.max(p, Math.max(smallAns1, smallAns2));
        
//         return storage[start][end];
        
//     }
    
}





















// Revision Session:

// class Solution {
//     public int maxProduct(int[] nums) {
        
// //         int maxProduct = Integer.MIN_VALUE;
        
// //         for(int i=0; i<nums.length; i++){
// //             for(int j=i; j<nums.length; j++){
// //                 int currProduct = getProduct(nums, i, j);
// //                 maxProduct = Math.max(maxProduct, currProduct);
// //             }
// //         }
// //         return maxProduct;
        
        
//         int[] min = new int[nums.length];
//         min[0] = nums[0];
//         int[] max = new int[nums.length];
//         max[0] = nums[0];
        
//         int ans = max[0];
        
//         for(int i=1; i<nums.length; i++){
            
//             if(nums[i] == 0){
//                 ans = Math.max(ans, max[i-1]);
//                 max[i] = 1;
//                 min[i] = 1;
                
//                 if(ans < 0)
//                     ans = 0;
                
//                 continue;
//             }
            
//             max[i] = Math.max(nums[i], Math.max((max[i-1] * nums[i]), (min[i-1] * nums[i])));
            
//             min[i] = Math.min(nums[i], Math.min((max[i-1] * nums[i]), (min[i-1] * nums[i])));
            
//             ans = Math.max(ans, max[i]);
            
//         }
        
//         return ans;
        
//     }
    
// //     public static int getProduct(int[] nums, int start, int end){
        
// //         int ans = 1;
        
// //         for(int i=start; i<=end; i++){
// //             ans = ans * nums[i];
// //         }
// //         return ans;
// //     }
    
// }







