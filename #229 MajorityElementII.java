class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i=0; i<n; i++){
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(Integer num : counts.keySet()){
            if(counts.get(num) > (n/3)){
                ans.add(num);
            }
        }
        return ans;
        
    }
}
