class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        
        return Math.max(houseRobber1(nums, 0, nums.length-2), houseRobber1(nums, 1, nums.length-1));
        
    }
    
    public static int houseRobber1(int[] nums, int start, int end){
        
        if(nums == null || start > end)
            return 0;
        
        if(start == end)
            return nums[start];
        
        int[] storage = new int[nums.length];
        
        storage[start] = nums[start];
        storage[start+1] = Math.max(nums[start], nums[start+1]);
        
        for(int i=start+2; i<=end; i++){
            storage[i] = Math.max(storage[i-1], storage[i-2] + nums[i]);
        }
        
        return storage[end];
    }
}
