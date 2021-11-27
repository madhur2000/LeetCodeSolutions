class Solution {
    public int firstMissingPositive(int[] nums) {
//         Approach-1: TLE | O(N^2)
        // Arrays.sort(nums);
        // if(nums[0] > 1 || nums[nums.length-1] < 1) return 1;
        // for(int i=1; i<nums.length; i++){
        //     if(nums[i]-1 != nums[i-1]){
        //         for(int j=nums[i-1]+1; j<nums[i]; j++){
        //             if(j > 0) return j;
        //         }
        //     }
        // }
        // return (nums[nums.length-1]+1);
        
        
        
//         Approach-2: 
        
        for(int i=0; i<nums.length; i++){
            while(nums[i] != i+1){
                // if(nums[i] < 0 || nums[i] >= nums.length){
                //     break;
                // }
                if(nums[i]-1 < 0 || nums[i]-1 >= nums.length)
                    break;
                if(nums[i] == nums[nums[i]-1])
                    break;
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return (i+1);
            }
        }
        return (nums[nums.length-1]+1);
    }
    static void swap(int[] nums, int i, int j){
        // if(j<0) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
