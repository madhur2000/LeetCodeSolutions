class Solution {
    public int[] productExceptSelf(int[] nums) {
        
//         Approach-1: Brute Force
        
//         int[] answer = new int[nums.length];
        
//         for(int i=0; i<nums.length; i++){
            
//             int p = 1;
//             for(int j=0; j<nums.length; j++){
//                 if(j != i){
//                     p = p * nums[j];
//                 }
//             }
//             answer[i] = p;
//         }
//         return answer;
        
        
//         Approach-2: optimized
        int[] answer = new int[nums.length];
        
        int p=1;
        for(int i=1; i<nums.length; i++){
            p = p * nums[i];
        }
        
        answer[0] = p;
        
        for(int i=1; i<nums.length; i++){
            
            if(nums[i] != 0){
                answer[i] = (answer[i-1] / nums[i]) * nums[i-1];
            }
            else{
                int p2 = 1;
                for(int u=0; u<nums.length; u++){
                    
                    if(i != u){
                        p2 = p2 * nums[u];
                    }
                }
                answer[i] = p2;
            }
        }
        return answer;
        
    
}
