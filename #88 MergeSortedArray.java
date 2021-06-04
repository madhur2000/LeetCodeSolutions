class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
//         Approach-1: time comp. = O(N+M); space complexity = O(N+M)
        
        int[] result = new int[nums1.length];
        
        int i=0, j=0;
        int g=0;
        
        while(i<m && j<n){
            
            if(nums1[i] <= nums2[j]){
                result[g++] = nums1[i];
                i++;
            }
            else{
                result[g++] = nums2[j];
                j++;
            }
            
        }
        while(i < m){
            result[g++] = nums1[i];
            i++;
        }
        
        while(j < n){
            result[g++] = nums2[j];
            j++;
        }
        
        for(int k=0; k<nums1.length; k++){
            nums1[k] = result[k];
        }
        
    }
}














// Approach-2: Time complexity= O(N+M); space = O(1)    (found in leetcode discuss)

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
        
//         int g = nums1.length-1;
//         int i = m-1;
//         int j = n-1;
        
//         while(i>=0 && j >= 0){
            
//             if(nums1[i] > nums2[j]){
//                 nums1[g--] = nums1[i];
//                 i--;
//             }
//             else{
//                 nums1[g--] = nums2[j--];
//             }
            
//         }
        
//         while(j >= 0){
            
//             nums1[g--] = nums2[j--];
            
//         }
        
        
//     }
// }
