class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }
    
    public static int helper(int startX, int startY, int m, int n){     //recursive
        
//         if(m == 0 || n == 0)    //edge case
//             return 0;
        
//         if(startX == m-1 || startY == n-1){     //base case
//             return 1;
//         }
        
//         int sa1 = helper(startX, startY+1, m, n);
//         int sa2 = helper(startX+1, startY, m, n);
        
//         return (sa1 + sa2);
        
        int[][] storage = new int[m][n];
        
//         Approach-2: Memoization
        // return uniquePathsM(startX, startY, m, n, storage);
        
//         Approach-3: DP (top-down)
        
        for(int i=0; i<n; i++){
            storage[m-1][i] = 1;
        }
        
        for(int i=0; i<m; i++){
            storage[i][n-1] = 1;
        }
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                storage[i][j] = storage[i][j+1] + storage[i+1][j];
            }
        }
        
        return storage[0][0];
        
    }
    
//     public static int uniquePathsM(int startX, int startY, int m, int n, int[][] storage){
        
        
//         if(m == 0 || n == 0)    //edge case
//             return 0;
        
//         if(startX == m-1 || startY == n-1){     //base case
            
//             storage[startX][startY] = 1;
//             return storage[startX][startY];
//         }
        
//         if(storage[startX][startY] != 0){
//             return storage[startX][startY];
//         }
        
//         int sa1 = helper(startX, startY+1, m, n);
        
//         storage[startX][startY+1] = sa1;
        
//         int sa2 = helper(startX+1, startY, m, n);
        
//         storage[startX+1][startY] = sa2;
        
//         storage[startX][startY] = sa1 + sa2;
//         return storage[startX][startY];
        
//     }
    
}
