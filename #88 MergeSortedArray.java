class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
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
