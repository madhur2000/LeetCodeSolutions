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


// Revision Session: (much better code)


class Solution {
    public int uniquePaths(int m, int n) {

//         Approach-1: Recursion (gives TLE)
        
//         if(m == 1 || n == 1)
//             return 1;
        
//         return(uniquePaths(m-1, n) + uniquePaths(m, n-1));
        
//         Approach-2: top-down DP
//         int[][] storage = new int[m+1][n+1];
        
//         for(int[] row : storage){
//             Arrays.fill(row, -1);
//         }
//         return helper(m, n, storage);
        
//         Approach-3: Bottom-up DP
        
        int[][] storage = new int[m+1][n+1];
        
        for(int i=0; i<=n; i++){
            storage[0][i] = 0;
        }
        for(int j=0; j<=m; j++){
            storage[j][0] = 0;
        }
        for(int i=1; i<=n; i++){
            storage[1][i] = 1;
        }
        for(int i=1; i<=m; i++){
            storage[i][1] = 1;
        }
        for(int i=2; i<=m; i++){
            for(int j=2; j<=n; j++){
                storage[i][j] = storage[i-1][j] + storage[i][j-1];
            }
        }
        return storage[m][n];
    }
    
//     public static int helper(int m, int n, int[][] storage){
        
//         if(m == 1 || n == 1)
//             return 1;
        
//         if(storage[m][n] != -1)
//             return storage[m][n];
        
//         int sa1 = helper(m-1, n, storage);
//         storage[m-1][n] = sa1;
        
//         int sa2 = helper(m, n-1, storage);
//         storage[m][n-1] = sa2;
        
//         storage[m][n] = sa1 + sa2;
//         return storage[m][n];
//     }
    
}





