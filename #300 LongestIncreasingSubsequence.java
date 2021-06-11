class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] storage = new int[nums.length];
        
        Arrays.fill(storage, 1);
        
        for(int i=1; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i]){
                    storage[i] = Math.max(storage[j]+1, storage[i]);
                }
            }
        }
        
        int ans = 1;
        for(int i=0; i<storage.length; i++){
            ans = Math.max(ans, storage[i]);
        }
        return ans;
    }
}
