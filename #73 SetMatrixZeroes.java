class Solution {
    public void setZeroes(int[][] matrix) {
        
//         Approach-1: time: O(M X N X (M + N)) | Space: O(M X N) | Accepted
        
//         List<String> cells = new LinkedList<>();
        
//         int rows = matrix.length;
//         int cols = matrix[0].length;
        
// //         storing positions of cells having zero
        
//         for(int i=0; i<rows; i++){
//             for(int j=0; j<cols; j++){
//                 if(matrix[i][j] == 0){
//                     cells.add(i + " " + j);
//                 }
//             }
//         }
        
//         for(String cell : cells){                in worst case, size of cells list will be (M X N). So this loop runs in O(M X N X (M+N))
//             String[] x_y = cell.split(" ");
//             int x = Integer.parseInt(x_y[0]);
//             int y = Integer.parseInt(x_y[1]);
            
//             for(int i=0; i<cols; i++){
//                 matrix[x][i] = 0;
//             }
//             for(int j=0; j<rows; j++){
//                 matrix[j][y] = 0;
//             }
//         }
        
        
//         Approach-2: Using Set | Time: O(M X N) | Space: O(M + N) | Accepted
        
//         Set<Integer> row_set = new HashSet<>();
//         Set<Integer> col_set = new HashSet<>();
        
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(matrix[i][j] == 0){
//                     row_set.add(i);
//                     col_set.add(j);
//                 }
//             }
//         }
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(row_set.contains(i) || col_set.contains(j))
//                     matrix[i][j] = 0;
//             }
//         }
        
//         Approach-3: Accepted | Time: O(M X N) | Space: O(M + N)
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;      //means that ith row elements need to be changed with 0
                    col[j] = true;      //means that jth column elements need to be changed with 0
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
