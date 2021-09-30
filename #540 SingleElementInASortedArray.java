class Solution {
    public int singleNonDuplicate(int[] nums) {
//         Approach-1: HashMap | time: O(N) | space: O(N)
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        // }
        // for(Integer num : map.keySet()){
        //     if(map.get(num) == 1)
        //         return num;
        // }
        // return -1;
        
//         Approach-2: HashSet | Time: O(N) | Space: O(N)
        // Set<Integer> set = new HashSet<>();
        // for(int i=0; i<nums.length; i++){
        //     if(!set.contains(nums[i])){
        //         set.add(nums[i]);
        //     } else{
        //         set.remove(nums[i]);
        //     }
        // }
        // for(Integer num : set){
        //     return num;
        // }
        // return -1;
        
//         Approach-3: Binary Search | Time: O(logN) | Space: O(1)
        
        int n = nums.length;
        int i=0;
        int j=n-1;
        
        while(i <= j){
            int mid = i + (j-i)/2;
            if((mid-1 < 0 || nums[mid-1] != nums[mid])
                && (mid+1 >= n || nums[mid+1] != nums[mid])){
                return nums[mid];
            }
            if(mid%2 == 0){
                if(nums[mid] == nums[mid+1])
                    i = mid;
                else
                    j = mid;
            }
            else{
                if(nums[mid] == nums[mid-1])
                    i = mid+1;
                else
                    j = mid-1;
            }
        }
        return -1;
    }
}
