class Solution {
    public int findDuplicate(int[] nums) {
        
        
//         Approach-1: Brute Force | TLE | Not Accepted
        
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] == nums[j])
        //             return nums[i];
        //     }
        // }
        // return -1;
        
        
        
        Approach-2: HashSet | O(N) | Accepted
        
        Set<Integer> hs = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }
            else{
                return nums[i];
            }
        }
        return -1;
        
        
//         Approach-3: Sorting | O(NlogN) | Accepted
        
//         Arrays.sort(nums);
        
//         for(int i=1; i<nums.length; i++){
//             if(nums[i] == nums[i-1])
//                 return nums[i];
//         }
//         return -1;
        
        
//         Approach-4: Tortoise And Hare | cycle detection | O(N)
        
        
        
    }
}
