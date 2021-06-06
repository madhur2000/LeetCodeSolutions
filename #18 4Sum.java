class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
//         Approach-1: O(N^4)
        
//         Arrays.sort(nums);
        
//         HashSet<List<Integer>> ansSet = new HashSet<>();
        
//         List<List<Integer>> ans = new ArrayList<>();
        
//         int n = nums.length;
        
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 for(int k=j+1; k<n; k++){
//                     for(int l=k+1; l<n; l++){
                        
//                         if(nums[i] + nums[j] + nums[k] + nums[l] == target){
//                             ansSet.add(new ArrayList<>(Arrays.asList(nums[i], nums[j],  nums[k], nums[l])));
//                         }
                        
//                     }
//                 }
//             }
//         }
//         ans = new ArrayList<>(ansSet);
//         return ans;
        
        
//         Approach-2: reducing 1 loop using binary search
        
        Arrays.sort(nums);
        
        HashSet<List<Integer>> ansSet = new HashSet<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    
                    int num4 = target - nums[i] - nums[j] - nums[k];
                    
                    boolean found = binarySearch(nums, num4, k+1);
                    
                    if(found){
                        ansSet.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], num4)));
                    }
                    
                }
            }
        }
        
        ans = new ArrayList<>(ansSet);
        return ans;
        
    }
    
    public static boolean binarySearch(int[] nums, int num, int start){
        
        // int start = k+1;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = (start + end)/2;
            
            if(num == nums[mid])
                return true;
            else if(num > nums[mid]){
                
                start = mid+1;
                
            }
            else{
                end = mid-1;
            }
            
        }
        return false;
    }
    
}
