class Solution {
    public int maxArea(int[] height) {
        
//         int n = height.length;
        
//         int ans = 0;
        
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 int currArea = Math.min(height[i], height[j]) * (j-i);
//                 ans = Math.max(ans, currArea);
//             }
//         }
//         return ans;
        
        
        int ans=0;
        int i=0;
        int j=height.length-1;
        
        while(i < j){
            
            int minStick = Math.min(height[i], height[j]);
            
            ans = Math.max(ans, (minStick * (j-i)));
            
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
            
        }
        return ans;
    }
}
