class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        // return helper(ob, ob.length, ob[0].length);
        
        int m = ob.length;
        int n = ob[0].length;
        
        int[][] storage = new int[m][n];
        
        if(ob[0][0] == 0){
            storage[0][0] = 1;
        } else{
            storage[0][0] = 0;
        }
        
        for(int i=1; i<m; i++){
            if(ob[i][0] == 1){
                storage[i][0] = 0;
                continue;
            }
            storage[i][0] = storage[i-1][0];
        }
        
        for(int i=1; i<n; i++){
            if(ob[0][i] == 1){
                storage[0][i] = 0;
                continue;
            }
            storage[0][i] = storage[0][i-1];
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(ob[i][j] == 1){
                    storage[i][j] = 0;
                    continue;
                }
                storage[i][j] = storage[i-1][j] + storage[i][j-1];
            }
        }
        return storage[m-1][n-1];
    }
    
//     public static int helper(int[][] ob, int m, int n){
        
//         if(ob[m-1][n-1] == 1)
//             return 0;
        
//         if(m == 1){
//             for(int i=0; i<n; i++){
//                 if(ob[0][i] == 1)
//                     return 0;
//             }
//             return 1;
//         }
//         if(n == 1){
//             for(int i=0; i<m; i++){
//                 if(ob[i][0] == 1)
//                     return 0;
//             }
//             return 1;
//         }
        
//         if(ob[m-1][n-2] == 1 && ob[m-2][n-1] == 1){
//             return 0;
//         }
        
//         if(ob[m-1][n-2] == 1){
//             return helper(ob, m-1, n);
//         }
        
//         if(ob[m-2][n-1] == 1){
//             return helper(ob, m, n-1);
//         }
        
//         return (helper(ob, m-1, n) + helper(ob, m, n-1));
//     }
}
