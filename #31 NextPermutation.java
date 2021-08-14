class Solution {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length-1;
        
        while((i-1) >= 0 && nums[i-1] >= nums[i]){
            i--;
        }
        
        if((i-1) < 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        int num = nums[i-1];
        
        int justGreater = Integer.MAX_VALUE;
        int index = -1;
        
        
//         this loop also works just fine.
        // for(int j=i; j<nums.length; j++){
        //     if(nums[j] > num && nums[j] <= justGreater){
        //         justGreater = nums[j];
        //         index = j;
        //     }
        // }
        
//         But this runs less no. of times and more understandable
        
        for(int k=nums.length-1; k>=i; k--){
            if(nums[k] > num){
                index = k;
                break;
            }
        }
        
        swap(nums, i-1, index);
        
        reverse(nums, i, nums.length-1);
        
    }
    
    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
