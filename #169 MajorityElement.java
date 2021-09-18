class Solution {
    public int majorityElement(int[] nums) {
        
//         Approach-1 | Time: O(N) | space: O(N)
        
//         int n = nums.length;
//         Map<Integer, Integer> counts = new HashMap<>();
        
//         for(int i=0; i<nums.length; i++){
//             counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
//         }
//         for(int i=0; i<nums.length; i++){
//             if(counts.get(nums[i]) > (n/2))
//                 return nums[i];
//         }
//         return -1;
        
//         Approach-2: Most voting algorithm
        
        int count = 0;
        int element = 0;
        
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(count == 0){
                element = nums[i];
            }
            if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
}
