class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            
            if((i-1) < 0 || nums[i] != nums[i-1]){

                int target = 0 - nums[i];
                int j = i+1;
                int k = nums.length-1;
                while(j < k){
                    if(nums[j] + nums[k] > target){
                        k--;
                    }
                    else if(nums[j] + nums[k] < target){
                        j++;
                    }
                    else{
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        int temp = nums[j];
                        while(j < nums.length && nums[j] == temp){
                            j++;
                        }
                        temp = nums[k];
                        while(k >=0 && nums[k] == temp){
                            k--;
                        }
                    }
                }
            }
        }
        
        // List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
