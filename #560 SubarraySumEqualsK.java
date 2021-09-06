class Solution {
    public int subarraySum(int[] nums, int k) {
        
//         Approach-1: ACCEPTED | Storing Cummulative sums | time: O(N^2) | space: O(N)
        
//         int n = nums.length;
//         int[] storage = new int[n];
//         storage[0] = nums[0];
        
//         for(int i=1; i<n; i++){
//             storage[i] = storage[i-1] + nums[i];
//         }
        
//         int count = 0;
        
//         for(int i=0; i<n; i++){
//             if(storage[i] == k)
//                 count++;
//         }
        
//         for(int i=1; i<n; i++){
//             for(int j=i; j<n; j++){
//                 if(storage[j] - storage[i-1] == k)
//                     count++;
//             }
//         }
        
//         return count;
        
        
//         Approach-2: ACCEPTED | Without Storing cummulative sums | Time: O(N^2) | space: O(1)
//
//         int count=0;
//         int n = nums.length;
        
//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums[j];
//                 if(sum == k)
//                     count++;
//             }
//         }
//         return count;
        
        
//         Approach-3: ACCEPTED | HashMap | Time: O(N) | Space: O(N)
        
        int n = nums.length;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(sum == k){
                count++;
            }
            if(hm.containsKey(sum - k)){
                count += hm.get(sum - k);
            }
            
//             putting the sum in hashmap
            if(!hm.containsKey(sum)){
                hm.put(sum, 1);
            }
            else{
                hm.put(sum, hm.get(sum)+1);
            }
        }
        return count;
    }
}
