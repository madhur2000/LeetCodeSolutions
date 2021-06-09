class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
//         Approach-1: Brute Force O(N^4) gives TLE
        
//         int n = nums1.length;
        
//         int count = 0;
        
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 for(int k=0; k<n; k++){
//                     for(int l=0; l<n; l++){
                        
//                         if(nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0){
//                             count++;
//                         }
                        
//                     }
//                 }
//             }
//         }
//         return count;
        
//         Approach-2: three pointers + binary search (gives TLE)
        
//         int n = nums1.length;
//         int count = 0;
        
//         Arrays.sort(nums4);     //coz we need to apply binary search on nums4
        
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 for(int k=0; k<n; k++){
//                     int smallAns = binarySearch(nums4, (0-nums1[i]-nums2[j]-nums3[k]));
//                     count += smallAns;
//                 }
//             }
//         }
//         return count;

//         Approach-3: HashMap O(N^2)
        
        int count = 0;
        int n = nums1.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(!hm.containsKey(nums1[i] + nums2[j])){
                    hm.put((nums1[i] + nums2[j]), 1);
                }
                else{
                    hm.put(nums1[i] + nums2[j], hm.get(nums1[i] + nums2[j]) + 1);
                }
                
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(hm.containsKey(0 - nums3[i] - nums4[j])){
                    count += hm.get(0 - nums3[i] - nums4[j]);
                }
            }
        }
        
        return count;
        
    }
    
    
//     public static int binarySearch(int[] nums, int target){
        
//         int count = 0;
        
//         int i=0;
//         int j=nums.length-1;
        
//         while(i <= j){
            
//             int mid = (i+j)/2;
            
//             if(nums[mid] == target){
                
//                 int itr = mid;
//                 while(itr >=0 && nums[itr] == target){
//                     count++;
//                     itr--;
//                 }
//                 itr = mid+1;
//                 while(itr < nums.length && nums[itr] == target){
//                     count++;
//                     itr++;
//                 }
//                 break;
//             }
            
//             else if(nums[mid] < target){
//                 i = mid+1;
//             }
            
//             else{
//                 j = mid-1;
//             }
            
//         }
//         return count;
//     }
}
