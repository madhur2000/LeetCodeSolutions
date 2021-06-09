class Solution {
    public int longestConsecutive(int[] nums) {
        
//         Approach-1: TLE for even smaller test cases coz question requires us to write an algorithm which works in O(N)
//         Arrays.sort(nums);
        
//         int count = 1;
//         int ans = 1;
        
//         for(int i=0; i<nums.length;){
//             for(int j=i+1; j<nums.length;){
//                 if(nums[j] - nums[i] == 1){
//                     count++;
//                     i++;
//                     j++;
//                 }
//                 else{
//                     ans = Math.max(ans, count);
//                     i = j;
//                     count++;
//                     break;
//                 }
//             }
//         }
//         return ans;
        
        int ans = 0;
        Set<Integer> hs = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            count = 1;
            if(!hs.contains(nums[i] - 1)){
                int temp = nums[i];
                while(hs.contains(temp + 1)){
                    temp = temp + 1;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
