class Solution {
    public void sortColors(int[] nums) {
        int g=0;
        int red_count=0;
        int white_count=0;
        int blue_count=0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) red_count++;
            else if(nums[i] == 1) white_count++;
            else blue_count++;
        }
        while(red_count-- > 0){
            nums[g++] = 0;
        }
        
        while(white_count-- > 0){
            nums[g++] = 1;
        }
        
        while(blue_count-- > 0){
            nums[g++] = 2;
        }
    }
}
