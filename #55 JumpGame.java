class Solution {
    public boolean canJump(int[] nums) {
        
//         Approach-1: Recursion (gives TLE)
        // return canJump(nums, 0);
        
        
//         Approach-2: top-down DP (gives TLE)
//         int[] storage = new int[nums.length];
//         Arrays.fill(storage, -1);
        
//         return canJumpM(nums, 0, storage);
        
        
//         Approach-3: bottom-up DP (Accepted)
        boolean[] storage = new boolean[nums.length];
        
        storage[0] = true;
        
        for(int i=1; i<storage.length; i++){
            
            for(int j=i-1; j>=0; j--){
                if(storage[j] == true && (j + nums[j]) >= i){
                    storage[i] = true;
                    break;
                }
            }
            
        }
        return storage[storage.length-1];
    }
    
//     public static boolean canJump(int[] nums, int start){
        
//         if(start > nums.length - 1)
//             return false;
//         if(start == nums.length - 1)
//             return true;
        
//         for(int i=nums[start]; i>=1; i--){
//             if(canJump(nums, start+i))
//                 return true;
//         }
//         return false;
//     }
    
//     public static boolean canJumpM(int[] nums, int start, int[] storage){
        
//         if(start > nums.length - 1)
//             return false;
        
//         if(start == nums.length - 1){
//             storage[start] = 1;
//             return true;
//         }
        
//         if(storage[start] != -1)
//             return (storage[start] == 1);
        
//         for(int i=nums[start]; i>=1; i--){
            
//             boolean smallAns = canJump(nums, start+i);
//             if((start + i) < nums.length){
//                 storage[start+i] = smallAns ? 1 : 0;
//             }
            
//             if(smallAns){
//                 storage[start] = 1;
//                 return true;
//             }
//         }
        
//         storage[start] = 0;
//         return false;
        
//     }
    
}
