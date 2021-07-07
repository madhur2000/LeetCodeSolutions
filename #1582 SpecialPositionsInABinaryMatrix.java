class Solution {
    public int numSpecial(int[][] mat) {
        
//         Approch-1: O(N^3)
        
//         int count = 0;
//         int rows = mat.length, cols = mat[0].length;
        
//         for(int i=0; i<rows; i++){
//             for(int j=0; j<cols; j++){
//                 if(mat[i][j] == 1){
//                     boolean oneFoundInRow = false;
//                     for(int m=0; m<cols; m++){
//                         if(m != j && mat[i][m] == 1){
//                             oneFoundInRow = true;
//                             break;
//                         }
//                     }
//                     boolean oneFoundInColumn = false;
//                     for(int n=0; n<rows; n++){
//                         if(n != i && mat[n][j] == 1){
//                             oneFoundInColumn = true;
//                             break;
//                         }
//                     }
//                     if(!oneFoundInRow && !oneFoundInColumn){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
        
        
//         Approach-2: O(N^2) | storing counts of 1's in each row and column
        
        int m = mat.length, n = mat[0].length;
        
        int[] row = new int[m];
        int[] column = new int[n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[j][i] == 1){
                    column[i]++;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    if(row[i] == 1 && column[j] == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
