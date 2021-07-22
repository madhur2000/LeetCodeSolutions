class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        // if(nums.length == 1) return 1;
        
        int i=0;
        int j=i+1;
        int k=0;
        
        while(j<nums.length && i < j){
            if(nums[j] == nums[i]){
                j++;
            }
            else{
                nums[k] = nums[i];
                k++;
                i = j;
                j = i+1;
            }
        }
        if((k-1) >= 0 && nums[k-1] == nums[i])
            return k;
        nums[k] = nums[i];
        return (k+1);
    }
}
