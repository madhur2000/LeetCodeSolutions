class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
//         Approach-1: Recursive
        // return helper(matrix, target, 0, 0);
        
//         Approach-2: Memoization
        // int[][] storage = new int[matrix.length][matrix[0].length];
        
        // for(int i=0; i<storage.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         storage[i][j] = -1;
        //     }
        // }
        
        // return (searchMatrixM(matrix, target, 0, 0, storage) == 1) ? true : false;
        
//         Approach-3: DP(top-down)
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] storage = new boolean[m][n];
        
        if(matrix[m-1][n-1] == target){
            return true;
        }
        else{
            storage[m-1][n-1] = false;
        }
        
        for(int i=n-2; i>=0; i--){
            
            if(matrix[m-1][i] == target){
                return true;
            }
            else{
                storage[m-1][i] = storage[m-1][i+1];
            }
            
        }
        
        for(int i=m-2; i>=0; i--){
            
            if(matrix[i][n-1] == target){
                return true;
            }
            else{
                storage[i][n-1] = storage[i+1][n-1];
            }
            
        }
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                
                if(matrix[i][j] == target)
                    return true;
                else{
                    storage[i][j] = (storage[i][j+1] || storage[i+1][j] 
                                     || storage[i+1][j+1]);
                }
                
            }
        }
        return storage[0][0];
        
    }
    
//     public static boolean helper(int[][] matrix, int target, int x, int y){ //recursive
        
//         if(matrix == null || matrix.length == 0)    //edge case
//             return false;
        
//         if(x >= matrix.length || y >= matrix[0].length)
//             return false;
        
//         if(x == matrix.length-1 && y == matrix[0].length-1){    //base case
            
//             if(matrix[x][y] == target)
//                 return true;
//             return false;
            
//         }
        
//         if(matrix[x][y] == target){
//             return true;
//         }
        
//         boolean sa1 = helper(matrix, target, x, y+1);
//         boolean sa2 = helper(matrix, target, x+1, y);
//         boolean sa3 = helper(matrix, target, x+1, y+1);
        
//         return (sa1 || sa2 || sa3);
        
//     }
    
//     public static int searchMatrixM(int[][] matrix, int target, int x, int y,
//                                         int[][] storage){
        
//         if(matrix == null || matrix.length == 0)    //edge case
//             return 0;
        
//         if(x >= matrix.length || y >= matrix[0].length)
//             return 0;
        
//         if(storage[x][y] != -1)
//             return storage[x][y];
        
// //         if(x == matrix.length-1 && y == matrix[0].length-1){    //base case
            
// //             if(matrix[x][y] == target){
// //                 storage[x][y] = 1;
// //                 return storage[x][y];
// //             }
// //             storage[x][y] = 0;
// //             return storage[x][y];
// //         }
        
        
//         if(matrix[x][y] == target){
//             storage[x][y] = 1;
//             return storage[x][y];
//         }
        
        
//         int sa1 = searchMatrixM(matrix, target, x, y+1, storage);
//         if(y+1 < matrix[0].length)
//             storage[x][y+1] = sa1;
        
//         int sa2 = searchMatrixM(matrix, target, x+1, y, storage);
//         if(x+1 < matrix.length)
//             storage[x+1][y] = sa2;
        
//         int sa3 = searchMatrixM(matrix, target, x+1, y+1, storage);
//         if((x+1 < matrix.length) && (y+1 < matrix[0].length))
//             storage[x+1][y+1] = sa3;
        
//         storage[x][y] = ((sa1 == 1)|| (sa2 == 1)|| (sa3 == 1)) ? 1 : 0;
        
        
//         return storage[x][y];
//     }
    
}
