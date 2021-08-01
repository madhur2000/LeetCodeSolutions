class Solution {
    public int missingNumber(int[] nums) {
        
//         Approach-1: O(NlogN)
        
//         Arrays.sort(nums);
        
//         int n = nums.length;
        
//         for(int i=0; i<=n; i++){
//             if(i >= n)
//                 return i;
//             if(nums[i] != i)
//                 return i;
//         }
//         return -1;
        
//         Approach-2: Sum
        
        int sum1=0, sum2=0;
        int n = nums.length;
        // for(int i=0; i<=n; i++){
        //     sum1 += i;
        // }
        
        sum1 = (n*(n+1))/2;
        
        for(int i=0; i<n; i++){
            sum2 += nums[i];
        }
        return (sum1-sum2);
    }
}
