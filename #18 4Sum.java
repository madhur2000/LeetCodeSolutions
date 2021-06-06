class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      
//       Approach-1: O(N^4)
        
        Arrays.sort(nums);
        
        HashSet<List<Integer>> ansSet = new HashSet<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            ansSet.add(new ArrayList<>(Arrays.asList(nums[i], nums[j],  nums[k], nums[l])));
                        }
                        
                    }
                }
            }
        }
        ans = new ArrayList<>(ansSet);
        return ans;
    }
}
