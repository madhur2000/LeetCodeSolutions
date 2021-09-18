class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
//         Approach-1 | Time: O(N*M) | space: O(N*M)
        
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         int[] a = new int[m * n];
//         int index = 0;
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 a[index++] = matrix[i][j];
//             }
//         }
        
//         return binarySearch(a, target);
        
        
//         Approach-2 | Time: O(N) | space: O(1)
        
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         for(int i=0; i<m; i++){
//             if(target > matrix[i][n-1])
//                 continue;
//             return binarySearch(matrix[i], target);
//         }
//         return false;
        
//         Approach-3:
        
//         int i=0;
//         int j=matrix[0].length-1;
        
//         while(i < matrix.length && j >= 0){
//             if(target == matrix[i][j])
//                 return true;
//             if(target > matrix[i][j])
//                 i++;
//             else{
//                 j--;
//             }
//         }
//         return false;
        
        
        // Approach-4: optimized approach-1
        
        return matrixBinarySearch(matrix, target);
        
    }
    
    private static boolean matrixBinarySearch(int[][] matrix, int target){
        
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = (m * n) - 1;
        
        while(i <= j){
            int mid = i + (j-i)/2;
            if(matrix[mid/n][mid%n] == target)
                return true;
            if(matrix[mid/n][mid%n] > target)
                j = mid-1;
            else
                i = mid+1;
        }
        return false;
    }
    
//     private static boolean binarySearch(int[] a, int target){
//         int i=0;
//         int j=a.length-1;
        
//         while(i <= j){
//             int mid = i + (j-i)/2;
//             if(a[mid] == target)
//                 return true;
//             else if(a[mid] < target){
//                 i=mid+1;
//             }
//             else{
//                 j=mid-1;
//             }
//         }
//         return false;
//     }
}
