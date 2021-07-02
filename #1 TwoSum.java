class Solution {
    
//     class Pair{
//         int freq;
//         int index;
//         public Pair(int freq, int index){
//             this.freq = freq;
//             this.index = index;
//         }
//     }
    
    public int[] twoSum(int[] nums, int target) {
        
//         Approach-1: Brute Force | O(N^2) | Accepted
        
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         int sum = nums[i] + nums[j];
        //         if(sum == target) return new int[]{i, j};
        //     }
        // }
        // return new int[0];
        
        
//      Approach-2: HashMap | O(N) | Accepted 
        
//         Map<Integer, Pair> hm = new HashMap<>();
        
//         for(int i=0; i<nums.length; i++){
//             if(!hm.containsKey(nums[i])){
//                 hm.put(nums[i], new Pair(1, i));
//             }
//             else{
//                 hm.put(nums[i], new Pair(hm.get(nums[i]).freq+1, i));
//             }
//         }
        
        
//         for(int i=0; i<nums.length; i++){
//             int second = target - nums[i];
//             if(hm.containsKey(second)){
//                 if(2 * nums[i] != target){
//                     return new int[]{i, hm.get(second).index};
//                 }
//                 else{
//                     if(hm.get(second).freq >= 2){
//                         return new int[]{i, hm.get(second).index};
//                     }
//                 }
//             }
//         }
//         return new int[0];
        
        
//         Approach-3: Optimized Approach-2
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(target - nums[i])){
                return new int[]{i, hm.get(target - nums[i])};
            }
            hm.put(nums[i], i);
        }
        return new int[0];
    }
}
