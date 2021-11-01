class Solution {
    public int maxProduct(int[] nums) {
        
//         Approach-1:
        
//         int maxProduct = Integer.MIN_VALUE;
        
//         for(int i=0; i<nums.length; i++){
//             for(int j=i; j<nums.length; j++){
//                 int currProduct = getProduct(nums, i, j);
//                 maxProduct = Math.max(maxProduct, currProduct);
//             }
//         }
//         return maxProduct;
        
//         Approach-2:
        
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
        
        
//         Approach-3: Pepcoding YouTube
        int currProduct = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            currProduct = currProduct * nums[i];
            ans = Math.max(ans, currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }
        currProduct = 1;
        for(int i=n-1; i>=0; i--){
            currProduct = currProduct * nums[i];
            ans = Math.max(ans, currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }
        return ans;
        
    }
    
//     public static int getProduct(int[] nums, int start, int end){
        
//         int ans = 1;
        
//         for(int i=start; i<=end; i++){
//             ans = ans * nums[i];
//         }
//         return ans;
//     }
    
}
