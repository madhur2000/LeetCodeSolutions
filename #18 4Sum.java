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
        
        
//         Approach-2: reducing 1 loop using binary search O((N^3)*logN)
        
//         Arrays.sort(nums);
        
//         HashSet<List<Integer>> ansSet = new HashSet<>();
        
//         List<List<Integer>> ans = new ArrayList<>();
        
//         int n = nums.length;
        
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 for(int k=j+1; k<n; k++){
                    
//                     int num4 = target - nums[i] - nums[j] - nums[k];
                    
//                     boolean found = binarySearch(nums, num4, k+1);
                    
//                     if(found){
//                         ansSet.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], num4)));
//                     }
                    
//                 }
//             }
//         }
        
//         ans = new ArrayList<>(ansSet);
//         return ans;
        
        
        
//         Approach-3: Two pointers + 'twoSum' or 'pairSum' approach
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length;){
            for(int j=i+1; j<nums.length;){
                int target2 = target - nums[i] - nums[j];
                int k=j+1;
                int l=nums.length-1;
                
                while(k < l){
                    if(nums[k] + nums[l] == target2){
                        List<Integer> smallAns = new ArrayList<>();
                        smallAns.add(nums[i]);
                        smallAns.add(nums[j]);
                        smallAns.add(nums[k]);
                        smallAns.add(nums[l]);
                        ans.add(smallAns);
                        int temp = nums[k];
                        while(k < nums.length && temp == nums[k]){
                            k++;
                        }
                        temp = nums[l];
                        while(l >= 0 && temp == nums[l]){
                            l--;
                        }
                    } else if(nums[k] + nums[l] < target2){
                        k++;
                    } else{
                        l--;
                    }
                }
                
                int temp = nums[j];
                while(j < nums.length && nums[j] == temp){
                    j++;
                }
                
            }
            
            int temp = nums[i];
            while(i < nums.length && nums[i] == temp){
                i++;
            }
        }
        return ans;
        
    }
    
//     public static boolean binarySearch(int[] nums, int num, int start){
        
//         // int start = k+1;
//         int end = nums.length-1;
        
//         while(start <= end){
            
//             int mid = (start + end)/2;
            
//             if(num == nums[mid])
//                 return true;
//             else if(num > nums[mid]){
                
//                 start = mid+1;
                
//             }
//             else{
//                 end = mid-1;
//             }
            
//         }
//         return false;
//     }
    
}
