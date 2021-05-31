class Solution {
    public void wiggleSort(int[] nums) {
        
        int[] ans = new int[nums.length];
        int g=0;
        
        Arrays.sort(nums);
        
        int i;
        
        if((nums.length & 1) == 0){
            i = (nums.length/2) - 1;
        }
        else{
            i = nums.length/2;
        }
        
        int j = nums.length - 1;
        
        while(i >= 0){
            
            if(i >= 0){
                ans[g++] = nums[i];
                i--;
            }
            
            if((((nums.length & 1) == 0) && j >= nums.length/2)
                || (((nums.length & 1) != 0) && j > nums.length/2)){
                ans[g++] = nums[j];
                j--;
            }          
        }
        
        for(int k=0; k<nums.length; k++){
            
            nums[k] = ans[k];
            
        }
        
    }
}
