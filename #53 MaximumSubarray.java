class Solution {
    public int maxSubArray(int[] nums) {
//         Approach-1: Brute Force | O(N^3)
//         int n = nums.length;
//         int ans = Integer.MIN_VALUE;
        
//         for(int i=0; i<n; i++){
//             for(int j=i; j<n; j++){
//                 int sum = 0;
//                 for(int k=i; k<=j; k++){
//                     sum = sum + nums[k];
//                 }
//                 ans = Math.max(ans, sum);
//             }
//         }
//         return ans;
        
//         Approach-1.1: improving brute force | O(N^2)
        
//         int n = nums.length;
//         int ans = Integer.MIN_VALUE;
        
//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums[j];
//                 ans = Math.max(ans, sum);
//             }
//         }
//         return ans;
        
        
//         Approach-2: DP | Not Accepted (Memory Limit Exceeded)
        
//         int n = nums.length;
//         int[][] storage = new int[n][n];
        
//         for(int i=0; i<n; i++){
//             storage[i][i] = nums[i];
//         }
        
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 storage[i][j] = storage[i][j-1] + nums[j];
//             }
//         }
        
//         int ans = Integer.MIN_VALUE;
        
//         for(int i=0; i<n; i++){
//             for(int j=i; j<n; j++){  
//                 ans = Math.max(ans, storage[i][j]);
//             }
//         }
//         return ans;
        
        
        
        
//         Approach-3: Kadane's algorithm
        
        int n = nums.length;
        int sum = 0;
        int maxSum = nums[0];
        
        for(int i=0; i<n; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
